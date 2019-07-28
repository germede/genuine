package org.fluentness.base.service.server;

import org.fluentness.base.service.Service;

import java.util.Map;

public interface Server extends Service {

    @Override
    default int getDefinitionPriority() {
        return 100;
    }

    void start(Map<String, HttpHandler> routing);

    void stop();
}
