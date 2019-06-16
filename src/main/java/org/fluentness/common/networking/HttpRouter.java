package org.fluentness.common.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Fluentness;
import org.fluentness.common.constants.PublicDirectories;
import org.fluentness.common.logging.Log;
import org.fluentness.controller.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.common.constants.HttpStatusCodes.*;

public enum HttpRouter implements HttpHandler {

    INSTANCE;

    public Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();
        for (Map.Entry<String, Controller> controller : Fluentness.INSTANCE.controllers.getAll().entrySet()) {
            for (Action action : controller.getValue().getActions()) {

                String route = controller.getValue().getBaseRoute() + action.getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Log.INSTANCE.warning(
                        "Controller action %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getKey(), action.getName());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Log.INSTANCE.warning(
                        "Cannot map controller action %s->%s because route '%s' is already registered",
                        controller.getKey(), action.getName(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    httpExchange -> {
                        Log.INSTANCE.debug(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                        callMethodAction(controller.getValue(), action, httpExchange);
                    });
            }

            // static resource manager
            Arrays.stream(PublicDirectories.class.getFields()).forEach(directory ->
                {
                    try {
                        routeHandlerMap.put("/" + directory.get(null), this);
                    } catch (IllegalAccessException e) {
                        Log.INSTANCE.error(e);
                    }
                }
            );

        }

        return routeHandlerMap;
    }

    private void callMethodAction(Controller controller, Action action, HttpExchange httpExchange) {
        try {
            HttpRequest request = new HttpRequest(httpExchange, controller.getBaseRoute() + action.getRoute());
            HttpRequestRegister.INSTANCE.putCurrent(request);
            HttpResponse response = action.getExecutor().execute(request);
            HttpRequestRegister.INSTANCE.removeCurrent();
            HttpServer.INSTANCE.serve(httpExchange, response);
        } catch (Exception e) {
            Log.INSTANCE.error(e);
            HttpServer.INSTANCE.serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public void handle(HttpExchange httpExchange) {
        // handle static resources
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
