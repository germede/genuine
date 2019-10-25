package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.backlog.Architecture;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.controller.DefaultController;

import java.util.LinkedList;
import java.util.List;

public final class Flow extends Architecture<Controller> {

    // per definition a singleton, can only be accessed via consumer
    private final static Flow instance = new Flow();

    // public but safe, as fluentness instance is required, which has private constructor
    public static Flow getInstance(Fluentness proxy) {
        return instance;
    }

    // avoids unintended instantiations
    private Flow() {

    }

    public List<Controller> getControllers() {
        List<Controller> result = new LinkedList<>();
        result.add(new DefaultController());
        for (Object object : instances.entrySet()) {
            if (object instanceof Controller) {
                result.add((Controller) object);
            }
        }
        return result;
    }
}
