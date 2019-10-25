package org.fluentness.service.server;

import org.fluentness.service.Service;

import java.util.Map;

public interface Server extends Service {

    void start(Map<String, HttpHandler> routing);

    void stop();
}
