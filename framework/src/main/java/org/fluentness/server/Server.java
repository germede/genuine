package org.fluentness.server;

import org.fluentness.configuration.Key;

public interface Server {

    Key<Integer> PORT = new Key<>(8000);
    Key<String> CONTEXT = new Key<>("/");
    Key<String> RESPONSE_ENCODING = new Key<>("UTF-8");
    Key<Boolean> SINGLE_PAGE_MODE = new Key<>(true);

    void start();

    void stop();
}
