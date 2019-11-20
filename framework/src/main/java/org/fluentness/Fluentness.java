package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleAction;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.controller.desktop.DesktopViewHolder;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.authentication.BasicAuthenticationService;
import org.fluentness.service.caching.MemoryCachingService;
import org.fluentness.service.configuration.DefaultConfigurationService;
import org.fluentness.service.injection.DefaultInjectionService;
import org.fluentness.service.injection.InjectionService;
import org.fluentness.service.loading.DefaultLoadingService;
import org.fluentness.service.loading.LoadingService;
import org.fluentness.service.logging.JulLoggingService;
import org.fluentness.service.mailing.JavaxMailingService;
import org.fluentness.service.persistence.OpenJpaPersistenceService;
import org.fluentness.service.routing.DefaultRoutingService;
import org.fluentness.service.serving.ServingService;
import org.fluentness.service.serving.TomcatServingService;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    private static final InjectionService INJECTION_SERVICE = new DefaultInjectionService();
    private static final LoadingService LOADING_SERVICE = new DefaultLoadingService();
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
        services.add(DefaultLoadingService.class);
        services.add(DefaultConfigurationService.class);
        services.add(JulLoggingService.class);
        services.add(OpenJpaPersistenceService.class);
        services.add(JavaxMailingService.class);
        if (application.getPlatform() == Application.Platform.WEB) {
            services.add(MemoryCachingService.class);
            services.add(BasicAuthenticationService.class);
            services.add(DefaultRoutingService.class);
            services.add(TomcatServingService.class);
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
                DesktopViewHolder desktop = controller.getDesktop();
                DesktopView.setGlobalStyle(desktop.getGlobalStyle());
                desktop.getMainView().render();
            }
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    private static void web(Application application) throws FluentnessException {
        INJECTION_SERVICE.getInstance(ServingService.class).start();
    }


    private Fluentness() {
    }
}