package org.fluentness;

import org.fluentness.backlog.Architecture;
import org.fluentness.base.exception.DefinitionException;
import org.fluentness.flow.Controller;
import org.fluentness.flow.BaseController;

import java.util.LinkedList;
import java.util.List;

public final class Flow extends Architecture<Controller> {

    private final static Flow INSTANCE = new Flow();

    static Flow getInstance() {
        return INSTANCE;
    }

    private Flow() {

    }

    @FunctionalInterface
    public interface Definer {
        void define(Flow flow) throws DefinitionException;
    }

    List<Controller> getControllers() {
        List<Controller> result = new LinkedList<>();
        result.add(new BaseController());
        for (Object object : instances.entrySet()) {
            if (object instanceof Controller) {
                result.add((Controller) object);
            }
        }
        return result;
    }
}
