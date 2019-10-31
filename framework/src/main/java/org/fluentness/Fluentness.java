package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;

import java.lang.reflect.Method;

public final class Fluentness {

    private Fluentness() {

    }

    public static void bootstrap(Application application, String[] args) {
        try {
            DependencyInjector.does.inject(application.getServices());
            DependencyInjector.does.inject(application.getRepositories());
            DependencyInjector.does.inject(application.getControllers());
            String name = args.length == 0 ? "help" : args[0];
            Method toExecute = Controller.getAllActions(DependencyInjector.does.getInstances(AbstractConsoleController.class))
                    .stream()
                    .filter(method -> method.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
            toExecute.invoke(DependencyInjector.does.getInstance(toExecute.getDeclaringClass()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ConsoleException extends AbstractException {
        ConsoleException(String stringToFormat, Object... parameters) {
            super(stringToFormat, parameters);
        }
    }
}