package org.fluentness.base.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Fluentness;
import org.fluentness.flow.provider.ControllerProvider;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.util.Map;

import static org.fluentness.base.service.config.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.StringKey.APP_HOST;
import static org.fluentness.base.service.config.StringKey.APP_PROTOCOL;

public class DefaultServer implements Server {

    private String protocol;
    private String host;
    private int port;
    private com.sun.net.httpserver.HttpServer server;

    @Override
    public void initialize() throws IOException {
        protocol = base(Config.class).get(APP_PROTOCOL);
        host = base(Config.class).get(APP_HOST);
        port = base(Config.class).get(APP_PORT);
        switch (protocol) {
            case "http":
                server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(host, port), 0);
                break;
            default:
                throw new ProtocolException();
        }
        server.setExecutor(null);
    }

    @Override
    public void start() {
        Map<String, HttpHandler> routeHandlerMap = Fluentness.getFlow().getProvider(ControllerProvider.class).getRouteHandlerMap();
        routeHandlerMap.forEach((key, value) -> server.createContext(key, value));

        server.start();
        base(Logger.class).info("Server successfully started and listening to %s", protocol + "://" + host + ":" + port);
    }


    @Override
    public void stop() {
        if (server != null) {
            server.stop(0);
            base(Logger.class).info("Server successfully stopped");
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
            base(Logger.class).severe(e);
        }
    }
}
