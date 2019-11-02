package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.service.manager.ClassLoadingException;
import org.fluentness.service.manager.DefaultManager;
import org.fluentness.service.manager.InjectionException;
import org.fluentness.service.manager.Manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    static Fluentness instance;

    public static void bootstrap(Application application, String[] args) throws FluentnessException {
        if (instance == null) {
            instance = new Fluentness(new DefaultManager());
        }
        if (application == null) {
            throw new FluentnessException("Passed application was null");
        }
        instance.initialize(application, args);
    }

    private Manager manager;

    Fluentness(Manager manager) {
        this.manager = manager;
    }

    private void initialize(Application application, String[] args) throws FluentnessException {
        try {
            application.injectServices(manager);
            application.injectRepositories(manager);
            application.injectControllers(manager);
            execute(args);
        } catch (InvocationTargetException | ClassLoadingException | IllegalAccessException | InjectionException | ConsoleException e) {
            throw new FluentnessException(e);
        }
    }

    private void execute(String[] args) throws ConsoleException, IllegalAccessException, InvocationTargetException {
        if (args == null) {
            throw new ConsoleException("Passed args was null");
        }
        String name = args.length == 0 ? "help" : args[0];
        List<Controller.Action> actions = new LinkedList<>();
        manager.getInstances(AbstractConsoleController.class)
            .forEach(abstractConsoleController -> actions.addAll(abstractConsoleController.getActions()));
        Method toExecute = actions
            .stream()
            .filter(action -> action.getMethod().getName().equals(name))
            .map(Controller.Action::getMethod)
            .findFirst()
            .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
        toExecute.invoke(manager.getInstance(toExecute.getDeclaringClass()));
    }
}