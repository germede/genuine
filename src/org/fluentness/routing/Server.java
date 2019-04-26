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
            setServerContexts(server);
            server.setExecutor(null);
            server.start();
            Logger.i("Server successfully started and listening to " + getBaseAddress());
        } catch (IOException e) {
            if (server != null) {
                server.stop(0);
            }
            Logger.e(e);
        }
    }

    public static String getBaseAddress() {
        try {
            return "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port;
        } catch (UnknownHostException e) {
            Logger.e(e);
        }
        return server.getAddress().toString();
    }

    private static void setServerContexts(com.sun.net.httpserver.HttpServer server) {
        for (Map.Entry<String, HttpHandler> entry : Router.getRouteHandlerMap().entrySet()) {
            server.createContext(entry.getKey(), entry.getValue());
        }
    }

    static void respond(HttpExchange httpExchange, HttpResponse httpResponse) {
        try {
            for (Map.Entry<String, String> header: httpResponse.getHeaders().entrySet()){
                httpExchange.getResponseHeaders().set(header.getKey(), header.getValue());
            }
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
