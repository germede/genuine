package org.fluentness.flow.provider;

import org.fluentness.base.Base;
import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.HttpHandler;
import org.fluentness.flow.component.controller.Action;
import org.fluentness.flow.component.controller.Controller;
import org.fluentness.flow.component.controller.ControllerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@DefinitionPriority(2400)
public abstract class ControllerProvider extends Provider<Controller> implements ControllerFactory, Base.Consumer {

    @Override
    public Class<Controller> getComponentClass() {
        return Controller.class;
    }


    public Map<String, HttpHandler> getRouting() {

        Map<String, HttpHandler> pathActionHandlerMap = new HashMap<>();
        for (Controller controller : provideComponents()) {
            for (Action action : controller.getActions()) {

                String route = controller.getBaseRoute() + action.getRoute();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    service(Logger.class).warn(
                        "Controller action %s->%s dynamic url parameter must stay at the end of the path",
                        controller.getName(), action.getName());
                    continue;
                }

                // already registered method warning
                if (pathActionHandlerMap.containsKey(route)) {
                    service(Logger.class).warn(
                        "Cannot map controller action %s->%s because route '%s' is already registered",
                        controller.getName(), action.getName(), route);
                    continue;
                }

                pathActionHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                    (httpServletRequest, httpServletResponse) ->
                    {
                        service(Logger.class).debug(
                            "%s %s",
                            httpServletRequest.getMethod(),
                            httpServletRequest.getRequestURI()
                        );

                        try {
                            action.getExecutor().handle(httpServletRequest);
                        } catch (IOException e) {
                            service(Logger.class).error(e);
                        }
                    });
            }

        }

        return pathActionHandlerMap;
    }


}
