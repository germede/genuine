package org.fluentness.common.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Settings;
import org.fluentness.common.logging.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.util.Map;

import static org.fluentness.common.constants.SettingKeys.*;

public enum  HttpServer {
    INSTANCE;

    private com.sun.net.httpserver.HttpServer server;
    private String protocol = Settings.INSTANCE.get(APP_PROTOCOL);
    private String hostname = Settings.INSTANCE.get(APP_HOST);
    private int port = Integer.parseInt(Settings.INSTANCE.get(APP_PORT));


    public void start() {
        try {
            switch (protocol) {
                case "http":
                    server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(hostname, port), 0);
                    break;
                default:
                    throw new ProtocolException();
            }

            Map<String, HttpHandler> routeHandlerMap = HttpRouter.INSTANCE.getRouteHandlerMap();
            routeHandlerMap.forEach((key, value) -> server.createContext(key, value));
            server.setExecutor(null);
            server.start();
            Log.INSTANCE.info("Server successfully started and listening to %s",getAddress());
        } catch (Exception e) {
            stop();
            Log.INSTANCE.error(e);
        }
    }

    private String getAddress() {
        return protocol + ":/" + server.getAddress().getAddress() + ":" + port;
    }

    public void stop() {
        if (server != null) {
            server.stop(0);
            Log.INSTANCE.info("Server successfully stopped");
        }
    }

    void serve(HttpExchange httpExchange, HttpResponse httpResponse) {
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
            Log.INSTANCE.error(e);
        }
    }
}
