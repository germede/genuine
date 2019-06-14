package org.fluentness.base.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsConfigurator;
import org.fluentness.Fluentness;
import org.fluentness.base.logging.Log;
import org.fluentness.controller.Response;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;

import static org.fluentness.base.constants.Settings.*;

public final class HttpServer extends HttpsConfigurator {

    private static com.sun.net.httpserver.HttpServer server;
    private static String protocol = Fluentness.getString(APP_PROTOCOL);
    private static String hostname = Fluentness.getString(APP_HOSTNAME);
    private static int port = Fluentness.getInt(APP_PORT);

    private HttpServer() {
        super(null);
    }

    public HttpServer(SSLContext sslContext) {
        super(sslContext);
    }

    public static void start() {
        try {
            switch (protocol) {
                case "http":
                    server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(hostname, port), 0);
                    break;
                case "https":
                    server = com.sun.net.httpserver.HttpsServer.create(new InetSocketAddress(hostname, port), 0);
                    ((com.sun.net.httpserver.HttpsServer) server).setHttpsConfigurator(new HttpsServer());
                    break;
                default:
                    throw new ProtocolException();
            }

            HttpRouter.INSTANCE.getRouteHandlerMap().forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);
            server.start();
            Log.info("Server successfully started and listening to %s",getAddress());
        } catch (Exception e) {
            stop();
            Log.error(e);
        }
    }

    private static String getAddress() {
        return protocol + ":/" + server.getAddress().getAddress() + ":" + port;
    }

    public static void stop() {
        if (server != null) {
            server.stop(0);
            Log.info("Server successfully stopped");
        }
    }

    static void serve(HttpExchange httpExchange, Response httpResponse) {
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
            Log.error(e);
        }
    }
}
