package org.fluentness.base.service.resourceHandler;

import com.sun.net.httpserver.HttpExchange;
import org.fluentness.base.service.logger.LoggerService;
import org.fluentness.base.service.server.HttpResponse;
import org.fluentness.base.service.server.ServerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.fluentness.base.common.constant.HttpStatusCodes.*;

public class DefaultResourceHandlerService implements ResourceHandlerService {

    @Override
    public void handle(HttpExchange httpExchange) {

        consumeService(LoggerService.class).fine(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());

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

                consumeService(ServerService.class).serve(httpExchange, response);
            } else {
                consumeService(LoggerService.class).warning("File " + path + " doesn't exists");
                consumeService(ServerService.class).serve(httpExchange, new HttpResponse(NOT_FOUND));
            }
        } catch (IOException e) {
            consumeService(LoggerService.class).severe(e);
            consumeService(ServerService.class).serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }
}
