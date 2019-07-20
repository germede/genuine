package org.fluentness.base.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Fluentness;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.flow.controller.Action;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.controller.ControllerProvider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.constants.HttpStatusCodes.INTERNAL_SERVER_ERROR;

public class Router {

    private HttpHandler staticHttpHandler;

    public Router(HttpHandler staticHttpHandler) {
        this.staticHttpHandler = staticHttpHandler;
    }

    public Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();
        for (Controller controller : Fluentness.flow.getProvider(ControllerProvider.class).getComponents()) {
            for (Action action : controller.getActions()) {

                String route = controller.getBaseRoute() + action.getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Fluentness.base.getLogger().warning(
                        "Controller action %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getName(), action.getName());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Fluentness.base.getLogger().warning(
                        "Cannot map controller action %s->%s because route '%s' is already registered",
                        controller.getName(), action.getName(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    httpExchange -> {
                        Fluentness.base.getLogger().fine(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                        callMethodAction(controller, action, httpExchange);
                    });
            }

            // static resource manager
            Arrays.stream(PublicDirectories.class.getFields()).forEach(directory ->
                {
                    try {
                        routeHandlerMap.put("/" + directory.get(null), staticHttpHandler);
                    } catch (IllegalAccessException e) {
                        Fluentness.base.getLogger().severe(e);
                    }
                }
            );

        }

        return routeHandlerMap;
    }

    private void callMethodAction(Controller controller, Action action, HttpExchange httpExchange) {
        try {
            HttpRequest request = new HttpRequest(httpExchange, controller.getBaseRoute() + action.getRoute());
            HttpRequestRegister.instance.putCurrent(request);
            HttpResponse response = action.getExecutor().execute(request);
            HttpRequestRegister.instance.removeCurrent();
            Fluentness.base.getServer().serve(httpExchange, response);
        } catch (Exception e) {
            Fluentness.base.getLogger().severe(e);
            Fluentness.base.getServer().serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }


}
