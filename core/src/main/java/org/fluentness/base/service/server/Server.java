package org.fluentness.base.service.server;

import com.sun.net.httpserver.HttpExchange;
import org.fluentness.base.service.Service;

import java.io.IOException;

public interface Server extends Service {
    void initialize() throws IOException;

    void start();

    void stop();

    void serve(HttpExchange httpExchange, HttpResponse httpResponse);
}
