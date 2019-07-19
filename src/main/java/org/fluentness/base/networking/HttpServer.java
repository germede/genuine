package org.fluentness.base.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.logging.Log;
import org.fluentness.base.settings.Settings;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.util.Map;

import static org.fluentness.base.settings.IntegerKey.APP_PORT;
import static org.fluentness.base.settings.StringKey.APP_HOST;
import static org.fluentness.base.settings.StringKey.APP_PROTOCOL;

public enum HttpServer {
    instance;

    private com.sun.net.httpserver.HttpServer server;
    private String protocol;
    private String hostname;
    private int port;

    public void initialize() {
        protocol = Settings.instance.get(APP_PROTOCOL);
        hostname = Settings.instance.get(APP_HOST);
        port = Settings.instance.get(APP_PORT);
        try {

            switch (protocol) {
                case "http":
                    server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(hostname, port), 0);
                    break;
                default:
                    throw new ProtocolException();
            }

            Map<String, HttpHandler> routeHandlerMap = HttpRouter.instance.getRouteHandlerMap();
            routeHandlerMap.forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);

        } catch (Exception e) {
            stop();
            Log.instance.error(e);
        }
    }

    public void start() {
        server.start();
        Log.instance.info("Server successfully started and listening to %s",
            protocol + ":/" + server.getAddress().getAddress() + ":" + port);
    }


    public void stop() {
        server.stop(0);
        Log.instance.info("Server successfully stopped");
    }

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
            Log.instance.error(e);
        }
    }
}
