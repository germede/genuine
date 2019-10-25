package org.fluentness.backbone.architecture;

import org.fluentness.backbone.exception.DefinitionException;
import org.fluentness.controller.Controller;
import org.fluentness.controller.console.ConsoleController;

import java.util.LinkedList;
import java.util.List;

public final class ControllerArchitecture extends AbstractArchitecture<Controller> {

    private final static ControllerArchitecture INSTANCE = new ControllerArchitecture();

    static ControllerArchitecture getInstance() {
        return INSTANCE;
    }

    private ControllerArchitecture() {

    }

    @FunctionalInterface
    public interface Definer {
        void define(ControllerArchitecture controllerArchitecture) throws DefinitionException;
    }

    List<org.fluentness.controller.Controller> getControllers() {
        List<org.fluentness.controller.Controller> result = new LinkedList<>();
        result.add(new ConsoleController());
        for (Object object : instances.entrySet()) {
            if (object instanceof org.fluentness.controller.Controller) {
                result.add((org.fluentness.controller.Controller) object);
            }
        }
        return result;
    }
}
