package org.fwf.net;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.fwf.log.Logger;
import org.fwf.log.Severity;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class Server {

    private static HttpServer server;
    private static int port = 8000;

    public static void start() {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            setServerContexts(server);
            server.setExecutor(null);
            server.start();
            Logger.log(Severity.INFO, "Server successfully started. Listening to http://localhost:" + port);
        } catch (IOException e) {
            Logger.log(Severity.ERROR, e.getMessage(), e);
        }
    }


    private static void setServerContexts(com.sun.net.httpserver.HttpServer server) {
        for (Map.Entry<String, HttpHandler> entry : Routing.getRouteHandlerMap().entrySet()) {
            server.createContext(entry.getKey(), entry.getValue());
        }
    }

}
