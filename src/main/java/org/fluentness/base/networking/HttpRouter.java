package org.fluentness.base.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.logging.Log;
import org.fluentness.flow.Flow;
import org.fluentness.flow.controller.Action;
import org.fluentness.flow.controller.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.constants.HttpStatusCodes.INTERNAL_SERVER_ERROR;

public enum HttpRouter {

    call;

    public Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();
        for (Controller controller : Flow.call.controllers.getAll()) {
            for (Action action : controller.getActions()) {

                String route = controller.getBaseRoute() + action.getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Log.call.warning(
                        "Controller action %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getName(), action.getName());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Log.call.warning(
                        "Cannot map controller action %s->%s because route '%s' is already registered",
                        controller.getName(), action.getName(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    httpExchange -> {
                        Log.call.debug(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                        callMethodAction(controller, action, httpExchange);
                    });
            }

            // static resource manager
            Arrays.stream(PublicDirectories.class.getFields()).forEach(directory ->
                {
                    try {
                        routeHandlerMap.put("/" + directory.get(null), HttpResourceHandler.call);
                    } catch (IllegalAccessException e) {
                        Log.call.error(e);
                    }
                }
            );

        }

        return routeHandlerMap;
    }

    private void callMethodAction(Controller controller, Action action, HttpExchange httpExchange) {
        try {
            HttpRequest request = new HttpRequest(httpExchange, controller.getBaseRoute() + action.getRoute());
            HttpRequestRegister.call.putCurrent(request);
            HttpResponse response = action.getExecutor().execute(request);
            HttpRequestRegister.call.removeCurrent();
            HttpServer.call.serve(httpExchange, response);
        } catch (Exception e) {
            Log.call.error(e);
            HttpServer.call.serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }
}
