package org.fluentness.data;

import org.fluentness.Fluentness;
import org.fluentness.backlog.Architecture;
import org.fluentness.data.repository.Repository;

public final class Data extends Architecture<Repository> {

    // per definition a singleton, can only be accessed via consumer
    private final static Data instance = new Data();

    // public but safe, as fluentness instance is required, which has private constructor
    public static Data getInstance(Fluentness proxy) {
        return instance;
    }

    // avoids unintended instantiations
    private Data() {

    }
}
