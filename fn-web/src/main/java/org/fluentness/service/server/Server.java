package org.fluentness.service.server;

import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.dispatcher.RouteDispatcher;

import javax.net.ssl.SSLContext;

public interface Server extends Service {

    Setting<Integer> PORT = new Setting<>(8080);
    Setting<String> CONTEXT = new Setting<>("");
    Setting<SSLContext> SSL_CONTEXT = new Setting<>();

    void start() throws Exception;

    void stop();

    RouteDispatcher getRouteDispatcher();
}
