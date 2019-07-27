package org.fluentness.base.service.resourceHandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.service.Service;

public interface ResourceHandlerService extends Service, HttpHandler {
    @Override
    default int getDefinitionPriority() {
        return 300;
    }

    void handle(HttpExchange httpExchange);
}
