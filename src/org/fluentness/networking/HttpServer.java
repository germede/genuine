package org.fluentness.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import org.fluentness.configuration.Configuration;
import org.fluentness.logging.Logger;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;

public final class HttpServer extends HttpsConfigurator {

    private static com.sun.net.httpserver.HttpServer server;
    private static String protocol = Configuration.getString(Configuration.APP_PROTOCOL);
    private static String hostname = Configuration.getString(Configuration.APP_HOSTNAME);
    private static int port = Configuration.getInt(Configuration.APP_PORT);

    private HttpServer() {
        super(null);
    }

    public HttpServer(SSLContext sslContext) {
        super(sslContext);
    }

    public static void start() {
        try {
            if (protocol.equals("http")) {
                server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(hostname, port), 0);
            } else if (protocol.equals("https")) {
                server = com.sun.net.httpserver.HttpsServer.create(new InetSocketAddress(hostname, port), 0);
                ((HttpsServer) server).setHttpsConfigurator(new HttpSecure());
            } else {
                throw new ProtocolException();
            }

            HttpRouter.getRouteHandlerMap().forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);
            server.start();
            Logger.info(HttpServer.class, "Server successfully started and listening to %s",
                    protocol + ":/" + server.getAddress().getAddress() + ":" + port
            );
        } catch (Exception e) {
            stop();
            Logger.error(HttpServer.class, e);
        }
    }

    public static void stop() {
        if (server != null) {
            server.stop(0);
            Logger.info(HttpServer.class, "Server successfully stopped");
        }
    }

    public static void serve(HttpExchange httpExchange, Response httpResponse) {
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
