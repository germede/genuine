package org.fluentness.flow.producer.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.Fluentness;
import org.fluentness.base.common.constant.HttpMethods;
import org.fluentness.base.common.constant.HttpStatusCodes;
import org.fluentness.base.common.constant.PublicDirectories;
import org.fluentness.flow.producer.Producer;
import org.fluentness.base.common.lambda.KeyValuePair;
import org.fluentness.base.service.server.HttpRequest;
import org.fluentness.base.service.server.HttpRequestRegister;
import org.fluentness.base.service.server.HttpResourceHandler;
import org.fluentness.base.service.server.HttpResponse;
import org.fluentness.flow.producer.view.View;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class ControllerProducer extends Producer<Controller> implements HttpMethods, HttpStatusCodes {

    @Override
    public Class<Controller> getProducedComponentType() {
        return Controller.class;
    }

    protected Controller actions(String baseRoute, KeyValuePair<Action>... actions) {
        return new Controller(baseRoute, actions);
    }

    protected Controller actions(KeyValuePair<Action>... actions) {
        return new Controller(actions);
    }

    protected Action get(String route, ActionExecutor action) {
        return new Action(GET, route, action);
    }

    protected Action head(String route, ActionExecutor action) {
        return new Action(HEAD, route, action);
    }

    protected Action post(String route, ActionExecutor action) {
        return new Action(POST, route, action);
    }

    protected Action put(String route, ActionExecutor action) {
        return new Action(PUT, route, action);
    }

    protected Action delete(String route, ActionExecutor action) {
        return new Action(DELETE, route, action);
    }

    protected Action connect(String route, ActionExecutor action) {
        return new Action(CONNECT, route, action);
    }

    protected Action options(String route, ActionExecutor action) {
        return new Action(OPTIONS, route, action);
    }

    protected Action trace(String route, ActionExecutor action) {
        return new Action(TRACE, route, action);
    }

    protected HttpResponse render(View view) {
        return new HttpResponse(OK).withBody(view.renderWithCache());
    }

    protected HttpResponse response(String body) {
        return new HttpResponse(OK).withBody(body);
    }

    protected HttpResponse redirect(String to) {
        return new HttpResponse(MOVED_PERMANENTLY).withHeader("Location", to);
    }

    public Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();
        for (Controller controller : getComponents()) {
            for (Action action : controller.getActions()) {

                String route = controller.getBaseRoute() + action.getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Fluentness.getBase().getService(Logger.class).warning(
                        "Controller action %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getName(), action.getName());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Fluentness.getBase().getService(Logger.class).warning(
                        "Cannot map controller action %s->%s because route '%s' is already registered",
                        controller.getName(), action.getName(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    httpExchange -> {
                        Fluentness.getBase().getService(Logger.class).fine(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                        callAction(controller, action, httpExchange);
                    });
            }

            // static resource manager
            Arrays.stream(PublicDirectories.class.getFields()).forEach(directory ->
                {
                    try {
                        routeHandlerMap.put("/" + directory.get(null), HttpResourceHandler.instance);
                    } catch (IllegalAccessException e) {
                        Fluentness.getBase().getService(Logger.class).severe(e);
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
            Fluentness.getBase().getServer().serve(httpExchange, response);
        } catch (Exception e) {
            Fluentness.getBase().getService(Logger.class).severe(e);
            Fluentness.getBase().getServer().serve(httpExchange, new HttpResponse(INTERNAL_SERVER_ERROR));
        }
    }

}
