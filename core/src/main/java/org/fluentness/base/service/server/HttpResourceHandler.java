package org.fluentness.base.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Fluentness;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.fluentness.base.common.constant.HttpStatusCodes.*;

public enum HttpResourceHandler implements HttpHandler {
    instance;

    @Override
    public void handle(HttpExchange httpExchange) {

        base(Logger.class).fine(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());

        String path = httpExchange.getRequestURI().getPath();
        try {
            path = path.substring(1).replace("//", "/");

            boolean exists = Files.exists(Paths.get(path));
            if (exists) {
                HttpResponse response = new HttpResponse(OK);

                response.withBody(new String(Files.readAllBytes(Paths.get(path))));

                if (path.endsWith(".js")) {
                    response.withHeader("Content-Type", "text/javascript");
                } else if (path.endsWith(".html")) {
                    response.withHeader("Content-Type", "text/html");
                } else if (path.endsWith(".css")) {
                    response.withHeader("Content-Type", "text/css");
                } else if (path.endsWith(".json")) {
                    response.withHeader("Content-Type", "application/json");
                } else if (path.endsWith(".svg")) {
                    response.withHeader("Content-Type", "image/svg+xml");
                }

                base(Server.class).serve(httpExchange, response);
            } else {
                base(Logger.class).warning("File " + path + " doesn't exists");
                base(Server.class).serve(httpExchange, new HttpResponse(NOT_FOUND));
            }
        } catch (IOException e) {
            base(Logger.class).severe(e);
            base(Server.class).serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }
}
