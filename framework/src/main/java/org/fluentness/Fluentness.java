package org.fluentness;

import org.fluentness.controller.Action;
import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.service.dependency.ClassLoadingException;
import org.fluentness.service.dependency.DefaultDependencyService;
import org.fluentness.service.dependency.InjectionException;
import org.fluentness.service.dependency.DependencyService;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static DependencyService dependencyService = new DefaultDependencyService();

    public static void bootstrap(Application application, String[] args) throws FluentnessException {
        if (application == null) {
            throw new FluentnessException("Passed application was null");
        }
        try {
            application.injectServices(dependencyService);
            application.injectRepositories(dependencyService);
            application.injectControllers(dependencyService);
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
        List<Action> actions = new LinkedList<>();
        dependencyService.getInstances(AbstractConsoleController.class)
            .forEach(abstractConsoleController -> actions.addAll(abstractConsoleController.getActions()));
        Method toExecute = actions
            .stream()
            .filter(action -> action.getMethod().getName().equals(name))
            .map(Action::getMethod)
            .findFirst()
            .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
        Class<? extends Controller> declaringClass = (Class<? extends Controller>) toExecute.getDeclaringClass();
        toExecute.setAccessible(true);
        toExecute.invoke(dependencyService.getInstance(declaringClass));
    }
}