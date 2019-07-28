package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.common.Architecture;
import org.fluentness.flow.provider.Provider;

public final class Flow extends Architecture<Provider> {

    // per definition a singleton, can only be accessed via consumer
    private final static Flow instance = new Flow();

    // public but safe, as fluentness instance is required, which has private constructor
    public static Flow getInstance(Fluentness proxy) {
        return instance;
    }

    // avoids unintended instantiations
    private Flow() {

    }
}
