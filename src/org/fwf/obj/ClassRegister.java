package org.fwf.obj;

import org.fwf.cli.Command;
import org.fwf.log.Logger;
import org.fwf.log.Severity;
import org.fwf.mvc.Controller;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class ClassRegister {

    private static ClassRegister instance;

    public static ClassRegister getInstance() {
        if (instance == null) {
            instance = new ClassRegister();
        }
        return instance;
    }

    private Set<Controller> controllerInstances;

    public Set<Controller> getControllerInstances() {
        if (controllerInstances == null) {
            controllerInstances = new HashSet<>();
            for (Class controllerClass : getControllerClasses()){
                try {
                    controllerInstances.add((Controller) controllerClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.log(Severity.ERROR, e.getMessage(), e);
                }
            }
        }
        return controllerInstances;
    }

    private Set<Class<? extends Controller>> getControllerClasses() {
        Reflections reflections = new Reflections("com.sample");
        return reflections.getSubTypesOf(Controller.class);
    }

    public Set<Class<? extends Command>> getCommandClasses() {
        Reflections reflections = new Reflections("org.frameworkflow");
        return reflections.getSubTypesOf(Command.class);
    }

}
