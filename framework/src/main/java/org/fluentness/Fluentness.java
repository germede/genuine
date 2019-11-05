package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.XmlConfigurationService;
import org.fluentness.service.dependency.ClassLoadingException;
import org.fluentness.service.dependency.DefaultDependencyService;
import org.fluentness.service.dependency.DependencyService;
import org.fluentness.service.dependency.InjectionException;
import org.fluentness.service.logger.JulLoggerService;
import org.fluentness.service.persistence.OpenJpaPersistenceService;
import org.fluentness.service.router.DefaultRouterService;
import org.fluentness.service.server.TomcatServerService;
import org.fluentness.service.translator.XmlTranslatorService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    private static DependencyService dependencyService = new DefaultDependencyService();
    private static Fluentness proxy = new Fluentness();

    private Fluentness() {
    }

    public static void bootstrap(Application application, String[] args) throws FluentnessException {
        if (application == null) {
            throw new FluentnessException("Passed application was null");
        }
        try {
            List<Class<? extends Service>> services = application.getServices(dependencyService);
            services.add(XmlConfigurationService.class);
            services.add(XmlTranslatorService.class);
            services.add(JulLoggerService.class);
            services.add(OpenJpaPersistenceService.class);
            services.add(DefaultRouterService.class);
            services.add(TomcatServerService.class);
            dependencyService.inject(proxy, services);

            List<Class<? extends Repository>> repositories = application.getRepositories(dependencyService);
            dependencyService.inject(proxy, repositories);

            List<Class<? extends Controller>> controllers = application.getControllers(dependencyService);
            controllers.add(DefaultConsoleController.class);
            dependencyService.inject(proxy, controllers);

            execute(args);
        } catch (InvocationTargetException | ClassLoadingException | IllegalAccessException | InjectionException | ConsoleException e) {
            throw new FluentnessException(e);
        }
    }

    private static void execute(String[] args) throws ConsoleException, IllegalAccessException, InvocationTargetException {
        if (args == null) {
            throw new ConsoleException("Passed args was null");
        }
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
        Class<? extends Controller> declaringClass = (Class<? extends Controller>) toExecute.getDeclaringClass();
        toExecute.setAccessible(true);
        toExecute.invoke(dependencyService.getInstance(declaringClass));
    }
}