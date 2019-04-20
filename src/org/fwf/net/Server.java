package org.fwf.net;

import com.sun.net.httpserver.HttpHandler;
import org.fwf.log.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class Server {

    private static com.sun.net.httpserver.HttpServer server;
    private static int port = 8000;

    public static void start() {
        try {
            server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port), 0);
            setServerContexts(server);
            server.setExecutor(null);
            server.start();
            Logger.i("Server successfully started and listening to http://localhost:" + port);
        } catch (IOException e) {
            if (server != null) {
                server.stop(0);
            }
            Logger.e(e);
        }
    }

    private static void setServerContexts(com.sun.net.httpserver.HttpServer server) {
        for (Map.Entry<String, HttpHandler> entry : Router.getRouteHandlerMap().entrySet()) {
            server.createContext(entry.getKey(), entry.getValue());
        }
    }
}
