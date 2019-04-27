package org.fluentness.routing;

import com.sun.net.httpserver.HttpExchange;
import org.fluentness.Configuration;
import org.fluentness.logging.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServer {

    private static com.sun.net.httpserver.HttpServer server;
    private static int port = Integer.parseInt(Configuration.get(Configuration.APP_PORT));

    public static void start() {
        try {
            server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port), 0);
            Router.getRouteHandlerMap().forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);
            server.start();
            Logger.info(HttpServer.class, "Server successfully started and listening to http://localhost:" + port);
        } catch (IOException e) {
            stop();
            Logger.error(HttpServer.class, e);
        }
    }

    public static void stop() {
        if (server != null) {
            server.stop(0);
        }
    }

    public static void respond(HttpExchange httpExchange, HttpResponse httpResponse) {
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
            Logger.error(HttpServer.class, e);
        }
    }
}
