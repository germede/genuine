package org.fluentness.base.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.logging.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.fluentness.base.constants.HttpStatusCodes.*;

public enum  HttpResourceHandler implements HttpHandler {

    INSTANCE;

    @Override
    public void handle(HttpExchange httpExchange) {

        Log.INSTANCE.debug(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());

        String path = httpExchange.getRequestURI().getPath();
        try {
            path = path.substring(1).replace("//", "/");

            boolean exists = Files.exists(Paths.get(path));
            if (exists) {
                HttpResponse response = new HttpResponse(OK);

                response.setBody(new String(Files.readAllBytes(Paths.get(path))));

                if (path.endsWith(".js")) {
                    response.setHeader("Content-Type", "text/javascript");
                } else if (path.endsWith(".html")) {
                    response.setHeader("Content-Type", "text/html");
                } else if (path.endsWith(".css")) {
                    response.setHeader("Content-Type", "text/css");
                } else if (path.endsWith(".json")) {
                    response.setHeader("Content-Type", "application/json");
                } else if (path.endsWith(".svg")) {
                    response.setHeader("Content-Type", "image/svg+xml");
                }

                HttpServer.INSTANCE.serve(httpExchange, response);
            } else {
                Log.INSTANCE.warning("File " + path + " doesn't exists");
                HttpServer.INSTANCE.serve(httpExchange, new HttpResponse(NOT_FOUND));
            }
        } catch (IOException e) {
            Log.INSTANCE.error(e);
            HttpServer.INSTANCE.serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }
}
