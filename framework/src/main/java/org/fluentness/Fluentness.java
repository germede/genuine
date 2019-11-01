package org.fluentness;

import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.PropertiesConfigurationService;
import org.fluentness.service.dependency.DefaultDependencyService;
import org.fluentness.service.dependency.DependencyService;
import org.fluentness.service.localization.PropertiesLocalizationService;
import org.fluentness.service.logger.JulLoggerService;
import org.fluentness.service.persistence.OpenJpaPersistenceService;
import org.fluentness.service.routing.DefaultRoutingService;
import org.fluentness.service.server.TomcatServerService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    private static DependencyService dependencyService;

    private Fluentness() {

    }

    public static void bootstrap(Application application, String[] args) {
        try {
            dependencyService = new DefaultDependencyService();

            List<Class<? extends Service>> services = application.getServices(dependencyService);
            services.add(PropertiesConfigurationService.class);
            services.add(PropertiesLocalizationService.class);
            services.add(JulLoggerService.class);
            services.add(OpenJpaPersistenceService.class);
            services.add(DefaultRoutingService.class);
            services.add(TomcatServerService.class);
            dependencyService.inject(services);

            dependencyService.inject(application.getRepositories(dependencyService));

            List<Class<? extends Controller>> controllers = application.getControllers(dependencyService);
            controllers.add(DefaultConsoleController.class);
            dependencyService.inject(controllers);

            execute(args);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void execute(String[] args) throws ConsoleException, IllegalAccessException, InvocationTargetException {
        String name = args.length == 0 ? "help" : args[0];
        List<Controller.Action> actions = new LinkedList<>();
        dependencyService.getInstances(AbstractConsoleController.class)
            .forEach(abstractConsoleController -> actions.addAll(abstractConsoleController.getActions()));
        Method toExecute = actions
            .stream()
            .filter(action -> action.getMethod().getName().equals(name))
            .map(Controller.Action::getMethod)
            .findFirst()
            .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
        toExecute.invoke(dependencyService.getInstance(toExecute.getDeclaringClass()));
    }

}