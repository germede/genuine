package org.fwf.obj;

import org.fwf.cli.Command;
import org.fwf.cnf.Configuration;
import org.fwf.log.Log;
import org.fwf.mvc.Controller;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class ClassRegister {

    // singleton
    private static ClassRegister instance;

    public static ClassRegister getInstance() {
        if (instance == null) {
            instance = new ClassRegister();
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
                    Log.e(e.getMessage(), e);
                }
            }
        }
        return commandInstances;
    }

    public Set<Class<? extends Command>> getCommandClasses() {
        // fwf commands
        Reflections reflections = new Reflections("org.fwf.cli");
        Set<Class<? extends Command>> result = new HashSet<>(reflections.getSubTypesOf(Command.class));

        // custom commands
        Reflections customReflections = new Reflections(Configuration.get(Configuration.BASE_PACKAGE));
        result.addAll(customReflections.getSubTypesOf(Command.class));

        return result;
    }

    // controllers
    private Set<Controller> controllerInstances;

    public Set<Controller> getControllerInstances() {
        if (controllerInstances == null) {
            controllerInstances = new HashSet<>();
            for (Class controllerClass : getControllerClasses()){
                try {
                    controllerInstances.add((Controller) controllerClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    Log.e(e.getMessage(), e);
                }
            }
        }
        return controllerInstances;
    }

    public Set<Class<? extends Controller>> getControllerClasses() {
        Reflections reflections = new Reflections(Configuration.get(Configuration.BASE_PACKAGE));
        return reflections.getSubTypesOf(Controller.class);
    }



}
