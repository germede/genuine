package org.fluentness.common.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.common.logging.Logger;
import org.fluentness.controller.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.fluentness.common.constants.HttpStatusCodes.*;

final class HttpResourceHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {
        Logger.debug(this.getClass(), exchange.getRequestMethod() + " " + exchange.getRequestURI());

        String path = exchange.getRequestURI().getPath();
        if (path.equals("/favicon.ico")) {
            path = "/icon/favicon.ico";
        }
        path = "/src/main" + path;
        try {
            path = path.substring(1).replace("//", "/");

            boolean exists = Files.exists(Paths.get(path));
            if (exists) {
                Response response = new Response(OK);

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

                HttpServer.serve(exchange, response);
            } else {
                Logger.warning(this.getClass(), "File " + path + " doesn't exists");
                HttpServer.serve(exchange, new Response(NOT_FOUND));
            }
        } catch (IOException e) {
            Logger.error(this.getClass(), e);
            HttpServer.serve(exchange, new Response(INTERNAL_SERVER_ERROR));
        }
    }
}
