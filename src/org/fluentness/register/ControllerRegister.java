package org.fluentness.register;

import org.fluentness.controller.Controller;
import org.fluentness.logging.Logger;

import java.util.HashSet;
import java.util.Set;

public final class ControllerRegister {
    public static final String CONTROLLER = "controller";

    private static final Set<Controller> controllerInstances;
    static {
        controllerInstances = new HashSet<>();
        for (Class controllerClass : ClassLoader.getExternalClasses(CONTROLLER, Controller.class)) {
            try {
                controllerInstances.add((Controller) controllerClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassLoader.class, e);
            }
        }
    }

    public static Set<Controller> getControllerInstances() {
        return controllerInstances;
    }

}
