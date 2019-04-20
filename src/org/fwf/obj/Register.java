package org.fwf.obj;

import org.fwf.cli.Command;
import org.fwf.cnf.Configuration;
import org.fwf.log.Logger;
import org.fwf.mvc.Controller;
import org.reflections.Reflections;

import java.util.*;

public class Register {

    // singleton
    private static Register instance;

    public static Register getInstance() {
        if (instance == null) {
            instance = new Register();
        }
        return instance;
    }

    // commands
    private Set<Command> commandInstances;

    public Set<Command> getCommandInstances() {
        if (commandInstances == null) {
            commandInstances = new HashSet<>();
            for (Class commandClass : getCommandClasses()){
                try {
                    commandInstances.add((Command) commandClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.e(e, e.getMessage());
                }
            }
        }
        return commandInstances;
    }

    private List<Class<? extends Command>> getCommandClasses() {
        // fwf commands
        Reflections reflections = new Reflections("org.fwf.cli");
        Set<Class<? extends Command>> result = new HashSet<>(reflections.getSubTypesOf(Command.class));

        // custom commands
        Reflections customReflections = new Reflections(Configuration.get(Configuration.APP_PACKAGE).concat(".command"));
        result.addAll(customReflections.getSubTypesOf(Command.class));

        // sort commands alphabetically
        List<Class<? extends Command>> sortedCommandClasses = new ArrayList<>(result);
        sortedCommandClasses.sort(Comparator.comparing(Class::getName));

        return sortedCommandClasses;
    }

    // controllers
    private Set<Controller> controllerInstances;

    public Set<Controller> getControllerInstances() {
        if (controllerInstances == null) {
            controllerInstances = new HashSet<>();
            for (Class controllerClass : getControllerClasses()){
                try {
                    Controller controller = (Controller) controllerClass.newInstance();
                    Injector.injectFields(controller);
                    controllerInstances.add(controller);
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.e(e, e.getMessage());
                }
            }
        }
        return controllerInstances;
    }

    private Set<Class<? extends Controller>> getControllerClasses() {
        Reflections reflections = new Reflections(Configuration.get(Configuration.APP_PACKAGE));
        return reflections.getSubTypesOf(Controller.class);
    }



}
