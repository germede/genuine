package org.fluentness.service.server;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

@Singleton
public interface Server extends Service {

    Key<String> CONTEXT = new Key<>();
    Key<Integer> PORT = new Key<>();
    Key<String> RESPONSE_ENCODING = new Key<>();
    Key<Boolean> SINGLE_PAGE_MODE = new Key<>();

    void start();

    void stop();
}
