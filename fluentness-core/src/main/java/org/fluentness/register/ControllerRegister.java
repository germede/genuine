package org.fluentness.register;

import org.fluentness.common.PackageNames;
import org.fluentness.controller.Controller;
import org.fluentness.logger.Logger;

import java.util.HashSet;
import java.util.Set;

public final class ControllerRegister {

    private static final Set<Controller> controllerInstances;

    static {
        controllerInstances = new HashSet<>();
        for (Class controllerClass : ClassLoader.getExternalClasses(PackageNames.CONTROLLER, Controller.class)) {
            try {
                Controller controller = (Controller) controllerClass.newInstance();
                ClassInjector.injectFields(controller);
                controllerInstances.add(controller);
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassLoader.class, e);
            }
        }
    }

    public static Set<Controller> getControllerInstances() {
        return controllerInstances;
    }

}
