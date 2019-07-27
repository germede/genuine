package org.fluentness.base.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.service.Service;

import java.util.Map;

public interface ServerService extends Service {

    @Override
    default int getDefinitionPriority() {
        return 200;
    }

    void start(Map<String, HttpHandler> routeHandlerMap);

    void serve(HttpExchange httpExchange, HttpResponse httpResponse);

    void stop();
}
