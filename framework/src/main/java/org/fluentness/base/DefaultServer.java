package org.fluentness.base;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.Config;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.HttpResponse;
import org.fluentness.base.service.server.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.util.Map;

import static org.fluentness.base.service.config.Key.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.Key.StringKey.APP_HOSTNAME;
import static org.fluentness.base.service.config.Key.StringKey.APP_PROTOCOL;

public class DefaultServer implements Server {

    private String protocol;
    private String host;
    private int port;
    private com.sun.net.httpserver.HttpServer internalServer;

    public DefaultServer() throws DefinitionException {
        try {
            protocol = service(Config.class).get(APP_PROTOCOL);
            host = service(Config.class).get(APP_HOSTNAME);
            port = service(Config.class).get(APP_PORT);
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
        service(Logger.class).info("Server successfully started and listening to %s", protocol + "://" + host + ":" + port);
    }


    @Override
    public void stop() {
        if (internalServer != null) {
            internalServer.stop(0);
            service(Logger.class).info("Server successfully stopped");
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
            service(Logger.class).fatal(e);
        }
    }
}
