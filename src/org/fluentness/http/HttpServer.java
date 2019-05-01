package org.fluentness.http;

import com.sun.net.httpserver.HttpExchange;
import org.fluentness.FnConf;
import org.fluentness.logging.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServer {

    private static com.sun.net.httpserver.HttpServer server;
    private static int port = FnConf.getInt(FnConf.APP_PORT);

    public static void start() {
        try {
            server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port), 0);
            HttpRouter.getRouteHandlerMap().forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);
            server.start();
            Log.info(HttpServer.class, "Server successfully started and listening to http://localhost:" + port);
        } catch (IOException e) {
            stop();
            Log.error(HttpServer.class, e);
        }
    }

    public static void stop() {
        if (server != null) {
            server.stop(0);
        }
    }

    public static void serve(HttpExchange httpExchange, HttpResponse httpResponse) {
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
            Log.error(HttpServer.class, e);
        }
    }
}
