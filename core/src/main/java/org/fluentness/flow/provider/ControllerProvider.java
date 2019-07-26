package org.fluentness.flow.provider;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.base.Base;
import org.fluentness.base.common.constant.PublicDirectories;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.*;
import org.fluentness.flow.component.controller.Action;
import org.fluentness.flow.component.controller.Controller;
import org.fluentness.flow.component.controller.ControllerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.common.constant.HttpStatusCodes.INTERNAL_SERVER_ERROR;

public abstract class ControllerProvider extends Provider<Controller> implements ControllerFactory, Base.Consumer {

    @Override
    public Class<Controller> getProducedComponentType() {
        return Controller.class;
    }


    public Map<String, HttpHandler> getRouteHandlerMap() {

        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();
        for (Controller controller : getComponents()) {
            for (Action action : controller.getActions()) {

                String route = controller.getBaseRoute() + action.getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    base(Logger.class).warning(
                        "Controller action %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getName(), action.getName());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    base(Logger.class).warning(
                        "Cannot map controller action %s->%s because route '%s' is already registered",
                        controller.getName(), action.getName(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    httpExchange -> {
                        base(Logger.class).fine(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                        callAction(controller, action, httpExchange);
                    });
            }

            // static resource manager
            Arrays.stream(PublicDirectories.class.getFields()).forEach(directory ->
                {
                    try {
                        routeHandlerMap.put("/" + directory.get(null), HttpResourceHandler.instance);
                    } catch (IllegalAccessException e) {
                        base(Logger.class).severe(e);
                    }
                }
            );

        }

        return routeHandlerMap;
    }

    private void callAction(Controller controller, Action action, HttpExchange httpExchange) {
        try {
            HttpRequest request = new HttpRequest(httpExchange, controller.getBaseRoute() + action.getRoute());
            HttpRequestRegister.instance.putCurrent(request);
            HttpResponse response = action.getExecutor().execute(request);
            HttpRequestRegister.instance.removeCurrent();
            base(Server.class).serve(httpExchange, response);
        } catch (Exception e) {
            base(Logger.class).severe(e);
            base(Server.class).serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }

}
