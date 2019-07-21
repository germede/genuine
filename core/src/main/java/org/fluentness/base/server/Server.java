package org.fluentness.base.server;

import com.sun.net.httpserver.HttpExchange;

public interface Server {
    void initialize();

    void start();

    void stop();

    void serve(HttpExchange httpExchange, HttpResponse httpResponse);
}
