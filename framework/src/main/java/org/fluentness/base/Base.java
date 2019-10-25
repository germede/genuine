package org.fluentness.base;

import org.fluentness.Fluentness;
import org.fluentness.base.service.Service;
import org.fluentness.backlog.Architecture;

public final class Base extends Architecture<Service> {

    // per definition a singleton, can only be accessed via consumer
    private final static Base instance = new Base();

    // public but safe, as fluentness instance is required, which has private constructor
    public static Base getInstance(Fluentness proxy) {
        return instance;
    }

    // avoids unintended instantiations
    private Base() {

    }
}
