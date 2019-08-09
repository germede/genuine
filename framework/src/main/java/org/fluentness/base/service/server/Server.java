package org.fluentness.base.service.server;

import org.fluentness.base.service.Service;

import java.util.Map;

public interface Server extends Service {

    void start(Map<String, HttpHandler> routing);

    void stop();
}
