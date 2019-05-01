package org.fluentness.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.logging.Logger;
import org.fluentness.server.HttpResponse;
import org.fluentness.server.HttpServer;
import org.fluentness.server.HttpStatusCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {
        Logger.debug(this.getClass(), exchange.getRequestMethod() + " " + exchange.getRequestURI());

        String path = exchange.getRequestURI().getPath();
        if (path.equals("/favicon.ico")) {
            path = "/res/icon/favicon.ico";
        }
        try {
            path = path.substring(1).replaceAll("//", "/");

            boolean exists = Files.exists(Paths.get(path));
            if (exists) {
                HttpResponse response = new HttpResponse(HttpStatusCode.Ok);

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

                HttpServer.respond(exchange, response);
            } else {
                Logger.warning(this.getClass(), "File " + path + " doesn't exists");
                HttpServer.respond(exchange, new HttpResponse(HttpStatusCode.NotFound));
            }
        } catch (IOException e) {
            Logger.error(this.getClass(), e);
            HttpServer.respond(exchange, new HttpResponse(HttpStatusCode.InternalServerError));
        }
    }
}
