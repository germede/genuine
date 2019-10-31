package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.service.dependency.DefaultDependencyService;
import org.fluentness.service.dependency.DependencyService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Fluentness {

    private static DependencyService dependencyService;

    private Fluentness() {

    }

    public static void bootstrap(Application application, String[] args) {
        try {
            dependencyService = new DefaultDependencyService();
            dependencyService.inject(application.getServices());
            dependencyService.inject(application.getRepositories());
            dependencyService.inject(application.getControllers());
            execute(args);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void execute(String[] args) throws ConsoleException, IllegalAccessException, InvocationTargetException {
        String name = args.length == 0 ? "help" : args[0];
        Method toExecute = Controller.getAllActions(dependencyService.getInstances(AbstractConsoleController.class))
                .stream()
                .filter(method -> method.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
        toExecute.invoke(dependencyService.getInstance(toExecute.getDeclaringClass()));
    }

    static class ConsoleException extends Exception {
        ConsoleException(String stringToFormat, Object... parameters) {
            super(stringToFormat, parameters);
        }
    }
}