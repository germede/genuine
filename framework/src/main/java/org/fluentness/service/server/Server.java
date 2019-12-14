package org.fluentness.service.server;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

@Singleton
public interface Server extends Service {

    Key<Integer> PORT = new Key<>(8000);
    Key<String> CONTEXT = new Key<>("/");
    Key<String> RESPONSE_ENCODING = new Key<>("UTF-8");
    Key<Boolean> SINGLE_PAGE_MODE = new Key<>(true);

    void start();

    void stop();
}
