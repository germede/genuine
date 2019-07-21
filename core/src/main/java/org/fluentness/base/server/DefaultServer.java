package org.fluentness.base.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Fluentness;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.util.Map;

import static org.fluentness.base.config.IntegerKey.APP_PORT;
import static org.fluentness.base.config.StringKey.APP_HOST;
import static org.fluentness.base.config.StringKey.APP_PROTOCOL;

public class DefaultServer implements Server {

    private Router router;
    private String protocol;
    private String host;
    private int port;
    private com.sun.net.httpserver.HttpServer server;

    public DefaultServer(Router router) {
        this.router = router;
    }

    @Override
    public void initialize() {
        protocol = Fluentness.base.getConfig().get(APP_PROTOCOL);
        host = Fluentness.base.getConfig().get(APP_HOST);
        port = Fluentness.base.getConfig().get(APP_PORT);
        try {

            switch (protocol) {
                case "http":
                    server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(host, port), 0);
                    break;
                default:
                    throw new ProtocolException();
            }

            Map<String, HttpHandler> routeHandlerMap = router.getRouteHandlerMap();
            routeHandlerMap.forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);

        } catch (Exception e) {
            stop();
            Fluentness.base.getLogger().severe(e);
        }
    }

    @Override
    public void start() {
        server.start();
        Fluentness.base.getLogger().info("Server successfully started and listening to %s", protocol + "://" + host + ":" + port);
    }


    @Override
    public void stop() {
        if (server != null) {
            server.stop(0);
            Fluentness.base.getLogger().info("Server successfully stopped");
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
            Fluentness.base.getLogger().severe(e);
        }
    }
}
