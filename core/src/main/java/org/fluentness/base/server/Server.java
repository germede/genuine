package org.fluentness.base.server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public interface Server {
    void initialize() throws IOException;

    void start();

    void stop();

    void serve(HttpExchange httpExchange, HttpResponse httpResponse);
}
