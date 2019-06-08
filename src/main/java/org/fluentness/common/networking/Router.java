package org.fluentness.common.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.FnAtoz;
import org.fluentness.common.logging.Logger;
import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.controller.Action;
import org.fluentness.controller.Controller;
import org.fluentness.controller.ControllerProvider.Route;
import org.fluentness.controller.Request;
import org.fluentness.controller.Response;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.common.constants.HttpStatusCodes.INTERNAL_SERVER_ERROR;

public final class Router {

    private Router() {
    }

    public static Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();

        Map<String, Controller> controllers = FnAtoz.getControllerProvider().provideAll();
        for (Map.Entry<String, Controller> controller : controllers.entrySet()) {

            // retrieve controller base route
            String baseRoute = extractBaseRouteFromController(controller.getKey());

            for (NamedValue<Action> action : controller.getValue().getActions()) {

                String route = baseRoute + action.value().getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Logger.warning(
                        "Controller method %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getKey(),
                        action.name());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Logger.warning(
                        "Cannot register controller method %s->%s because route '%s' is already registered",
                        controller.getKey(),
                        action.name(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    httpExchange -> {
                        Logger.debug(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                        invokeControllerMethod(controller, action.value(), httpExchange);
                    });
            }

            // static resource manager
            routeHandlerMap.put("/resources/", new HttpResourceHandler());

            // favicon route
            routeHandlerMap.put("/favicon.ico", new HttpResourceHandler());
        }

        return routeHandlerMap;
    }

    public static String extractBaseRouteFromController(String controllerName) {
        return FnAtoz.getControllerProvider().isAnnotationPresent(controllerName, Route.class) ?
                    ((Route) FnAtoz.getControllerProvider().getAnnotation(controllerName, Route.class)).value() :
                    "";
    }


    private static void invokeControllerMethod(Map.Entry<String, Controller> controller, Action action, HttpExchange httpExchange) {
        try {
            // invoke controller method and serve
            Request request = new Request(httpExchange,
                extractBaseRouteFromController(controller.getKey()) + action.getRoute());
            RequestRegister.putCurrent(request);
            Response response = action.getExecutor().execute(request);
            RequestRegister.removeCurrent();
            HttpServer.serve(httpExchange, response);

        } catch (Exception e) {
            Logger.error(e);
            HttpServer.serve(httpExchange, new Response(INTERNAL_SERVER_ERROR));
            // exception within controller method invocation
        }
    }
}
