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
import org.fluentness.service.injector.DefaultInjector;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.loader.DefaultLoader;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.mailer.JavaxMailer;
import org.fluentness.service.persistence.OpenJpaPersistence;
import org.fluentness.service.router.DefaultRouter;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    private static final Injector INJECTION_SERVICE = new DefaultInjector();
    private static final Loader LOADING_SERVICE = new DefaultLoader();
    private static final Fluentness PROXY = new Fluentness();

    private static Application application;

    public static Application getApplication() {
        return application;
    }

    public static void launch(Application application, String[] args) throws FluentnessException {
        Fluentness.application = application;
        init(application);
        switch (application.getPlatform()) {
            case DESKTOP:
                desktop(application);
                break;
            case WEB:
                web(application);
                break;
            default:
                console(application, args);
        }
    }

    private static void init(Application application) throws FluentnessException {
        if (application == null) {
            throw new FluentnessException("Passed application was null");
        }
        List<Class<? extends Service>> services = application.getServices(LOADING_SERVICE);
        services.add(DefaultLoader.class);
        services.add(DefaultConfigurator.class);
        services.add(JulLogger.class);
        services.add(OpenJpaPersistence.class);
        services.add(JavaxMailer.class);
        if (application.getPlatform() == Application.Platform.WEB) {
            services.add(MemoryCache.class);
            services.add(BasicAuthenticator.class);
            services.add(DefaultRouter.class);
            services.add(TomcatServer.class);
        }
        INJECTION_SERVICE.inject(services);

        List<Class<? extends Repository>> repositories = application.getRepositories(LOADING_SERVICE);
        INJECTION_SERVICE.inject(repositories);

        List<Class<? extends Controller>> controllers = application.getControllers(LOADING_SERVICE);
        controllers.add(DefaultConsoleController.class);
        INJECTION_SERVICE.inject(controllers);

    }

    private static void console(Application application, String[] args) throws FluentnessException {
        try {
            if (args == null) {
                throw new ConsoleException("Passed args was null");
            }
            String name = args.length == 0 ? "help" : args[0];
            List<ConsoleAction> actions = new LinkedList<>();
            INJECTION_SERVICE.getInstances(AbstractConsoleController.class)
                .forEach(abstractConsoleController -> actions.addAll(abstractConsoleController.getActions()));
            Method toExecute = actions
                .stream()
                .filter(action -> action.getMethod().getName().equals(name))
                .map(ConsoleAction::getMethod)
                .findFirst()
                .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
            Class<? extends Controller> declaringClass = (Class<? extends Controller>) toExecute.getDeclaringClass();
            toExecute.setAccessible(true);
            toExecute.invoke(INJECTION_SERVICE.getInstance(declaringClass));
        } catch (ConsoleException | IllegalAccessException | InvocationTargetException e) {
            throw new FluentnessException(e);
        }
    }

    private static void desktop(Application application) throws FluentnessException {
        try {
            for (AbstractDesktopController controller : INJECTION_SERVICE.getInstances(AbstractDesktopController.class)) {
                DesktopView.setGlobalStyle(controller.getDesktop().style());
                controller.getDesktop().view().render();
            }
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    private static void web(Application application) throws FluentnessException {
        INJECTION_SERVICE.getInstance(Server.class).start();
    }


    private Fluentness() {
    }
}