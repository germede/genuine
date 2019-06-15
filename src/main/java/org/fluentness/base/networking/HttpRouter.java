package org.fluentness.base.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Fluentness;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.logging.Log;
import org.fluentness.controller.*;
import org.fluentness.controller.ControllerProducer.Route;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.constants.HttpStatusCodes.*;

public enum HttpRouter implements HttpHandler {

    INSTANCE;

    public Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();

        Map<String, Controller> controllers = Fluentness.INSTANCE.controllers.getAll();
        for (Map.Entry<String, Controller> controller : controllers.entrySet()) {

            // retrieve controller base route
            String baseRoute = extractBaseRouteFromController(controller.getKey());

            for (KeyValuePair<Action> action : controller.getValue().getActions()) {

                String route = baseRoute + action.value().getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Log.INSTANCE.warning(
                        "Controller method %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getKey(),
                        action.key());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Log.INSTANCE.warning(
                        "Cannot map controller method %s->%s because route '%s' is already registered",
                        controller.getKey(),
                        action.key(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    httpExchange -> {
                        Log.INSTANCE.debug(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                        callMethodAction(controller, action.value(), httpExchange);
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

    private void callMethodAction(Map.Entry<String, Controller> controller, Action action, HttpExchange httpExchange) {
        try {
            Request request = new Request(httpExchange, extractBaseRouteFromController(controller.getKey()) + action.getRoute());
            RequestRegister.INSTANCE.put(Thread.currentThread(), request);
            Response response = action.getExecutor().execute(request);
            RequestRegister.INSTANCE.remove(Thread.currentThread());
            HttpServer.INSTANCE.serve(httpExchange, response);
        } catch (Exception e) {
            Log.INSTANCE.error(e);
            HttpServer.INSTANCE.serve(httpExchange, new Response(INTERNAL_SERVER_ERROR));
        }
    }

    private String extractBaseRouteFromController(String controllerName) {
        return Fluentness.INSTANCE.controllers.isAnnotationPresent(controllerName, Route.class) ?
            ((Route) Fluentness.INSTANCE.controllers.getAnnotation(controllerName, Route.class)).value() :
            "";
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

                HttpServer.INSTANCE.serve(httpExchange, response);
            } else {
                Log.INSTANCE.warning("File " + path + " doesn't exists");
                HttpServer.INSTANCE.serve(httpExchange, new Response(NOT_FOUND));
            }
        } catch (IOException e) {
            Log.INSTANCE.error(e);
            HttpServer.INSTANCE.serve(httpExchange, new Response(INTERNAL_SERVER_ERROR));
        }
    }
}
