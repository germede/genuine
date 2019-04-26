package org.fluentness.routing;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.fluentness.Configuration;
import org.fluentness.logging.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class Server {

    private static HttpServer server;
    private static int port = Integer.parseInt(Configuration.get(Configuration.APP_PORT));

    public static void start() {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            Router.getRouteHandlerMap().forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);
            server.start();
            Logger.i("Server successfully started and listening to http://localhost:" + port);
        } catch (IOException e) {
            stop();
            Logger.e(e);
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
            Logger.e(e);
        }
    }
}
