package org.fluentness;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injection.Provider;

public interface Application {

    void provide(Provider provider);

    void configure(Configuration configuration);

    void run(String[] args) throws Exception;

    interface Component {
        // Application components are the only objects that are injectable by Fluentness
    }
}
