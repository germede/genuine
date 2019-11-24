package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleAction;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.cache.MemoryCache;
import org.fluentness.service.configurator.DefaultConfigurator;
import org.fluentness.service.injector.FinalInjector;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.loader.FinalLoader;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.mailer.JavaxMailer;
import org.fluentness.service.persistence.OpenJpaPersistence;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    private static Application application;

    public static Application getApplication() {
        return application;
    }

    public static void launch(Application application, String[] args) throws FluentnessException {
        if (application == null) {
            throw new FluentnessException("Passed application was null");
        }
        Fluentness.application = application;
        Injector injector = makeInjector(application);
        switch (application.getPlatform()) {
            case DESKTOP:
                desktop(injector, application);
                break;
            case WEB:
                web(injector, application);
                break;
            default:
                console(injector, application, args);
        }
    }

    private static Injector makeInjector(Application application) throws FluentnessException {
        Loader loader = new FinalLoader();

        List<Class<? extends Service>> services = new LinkedList<>();
        services.add(DefaultConfigurator.class);
        services.add(JulLogger.class);
        services.add(JavaxMailer.class);
        services.add(OpenJpaPersistence.class);
        if (application.getPlatform().equals(Application.Platform.WEB)) {
            services.add(MemoryCache.class);
            services.add(BasicAuthenticator.class);
            services.add(TomcatServer.class);
        }
        services.addAll(application.getServices(loader));

        List<Class<? extends Repository>> repositories = application.getRepositories(loader);

        List<Class<? extends Controller>> controllers = application.getControllers(loader);
        controllers.add(DefaultConsoleController.class);

        return new FinalInjector(loader, services, repositories, controllers);
    }

    private static void console(Injector injector, Application application, String[] args) throws FluentnessException {
        try {
            if (args == null) {
                throw new ConsoleException("Passed args was null");
            }
            String name = args.length == 0 ? "help" : args[0];
            List<ConsoleAction> actions = new LinkedList<>();
            injector.getInstances(AbstractConsoleController.class)
                .forEach(abstractConsoleController -> actions.addAll(abstractConsoleController.getActions()));
            Method toExecute = actions
                .stream()
                .filter(action -> action.getMethod().getName().equals(name))
                .map(ConsoleAction::getMethod)
                .findFirst()
                .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
            Class<? extends Controller> declaringClass = (Class<? extends Controller>) toExecute.getDeclaringClass();
            toExecute.setAccessible(true);
            toExecute.invoke(injector.getInstance(declaringClass));
        } catch (ConsoleException | IllegalAccessException | InvocationTargetException e) {
            throw new FluentnessException(e);
        }
    }

    private static void desktop(Injector injector, Application application) throws FluentnessException {
        try {
            for (AbstractDesktopController controller : injector.getInstances(AbstractDesktopController.class)) {
                DesktopView.setGlobalStyle(controller.getDesktop().style());
                controller.getDesktop().view().render();
            }
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    private static void web(Injector injector, Application application) throws FluentnessException {
        injector.getInstance(Server.class).start();
    }


    private Fluentness() {
    }
}