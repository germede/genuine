package org.fluentness.base.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.ConfigService;
import org.fluentness.base.service.logger.LoggerService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.util.Map;

import static org.fluentness.base.service.config.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.StringKey.APP_HOST;
import static org.fluentness.base.service.config.StringKey.APP_PROTOCOL;

public class DefaultServerService implements ServerService {

    private String protocol;
    private String host;
    private int port;
    private com.sun.net.httpserver.HttpServer internalServer;

    public DefaultServerService() throws DefinitionException {
        try {
            protocol = consumeService(ConfigService.class).get(APP_PROTOCOL);
            host = consumeService(ConfigService.class).get(APP_HOST);
            port = consumeService(ConfigService.class).get(APP_PORT);
            switch (protocol) {
                case "http":
                    internalServer = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(host, port), 0);
                    break;
                default:
                    throw new ProtocolException();
            }
            internalServer.setExecutor(null);
        } catch (IOException e) {
            throw new DefinitionException(e);
        }
    }

    @Override
    public void start(Map<String, HttpHandler> routeHandlerMap) {
        routeHandlerMap.forEach((key, value) -> internalServer.createContext(key, value));

        internalServer.start();
        consumeService(LoggerService.class).info("Server successfully started and listening to %s", protocol + "://" + host + ":" + port);
    }


    @Override
    public void stop() {
        if (internalServer != null) {
            internalServer.stop(0);
            consumeService(LoggerService.class).info("Server successfully stopped");
        }
    }

    @Override
    public void serve(HttpExchange httpExchange, HttpResponse httpResponse) {
        try {
            httpResponse.getHeaders().forEach((key, value) -> httpExchange.getResponseHeaders().set(key, value));
            httpExchange.sendResponseHeaders(httpResponse.getStatusCode(), httpResponse.getBody().getBytes().length);

            if (httpResponse.getBody().length() > 0) {
                OutputStream os = httpExchange.getResponseBody();
                os.write(httpResponse.getBody().getBytes());
                os.close();
            }

            httpExchange.close();
        } catch (IOException e) {
            consumeService(LoggerService.class).severe(e);
        }
    }
}
