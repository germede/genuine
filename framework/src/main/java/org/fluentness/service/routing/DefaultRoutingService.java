package org.fluentness.service.routing;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.dependency.DependencyService;
import org.fluentness.service.server.HttpHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultRoutingService implements RoutingService {

    private DependencyService dependencyService;

    public DefaultRoutingService(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
    }

    @Override
    public Map<String, HttpHandler> getRoutingMap() {
        List<AbstractWebController> webControllers = dependencyService.getInstances(AbstractWebController.class);
        Map<String, HttpHandler> result = new HashMap<>();
        webControllers.forEach(controller -> {
            Arrays.stream(controller.getActions()).forEach(action -> {
                result.put(controller.getActionPath(action), getHttpHandlerForAction(controller, action));
            });
        });
        return result;
    }

    private HttpHandler getHttpHandlerForAction(AbstractWebController controller, Method action) {
        Class<?> returnType = action.getReturnType();
        if (returnType.equals(String.class)) {
            return (request, response) -> response.getWriter().write((String) action.invoke(controller, mapParameters(action, request, response)));
        } else if (returnType.equals(Integer.class) || returnType.equals(Integer.TYPE)) {
            return (request, response) -> response.setStatus((Integer) action.invoke(controller, mapParameters(action, request, response)));
        } else if (returnType.equals(WebView.class)) {
            return (request, response) -> response.getWriter().write(((WebView) action.invoke(controller, mapParameters(action, request, response))).render());
        }
        return (request, response) -> action.invoke(controller);
    }

    private Object[] mapParameters(Method action, HttpServletRequest request, HttpServletResponse response) {
        Parameter[] actionParameters = action.getParameters();
        Object[] result = new Object[actionParameters.length];
        switch (request.getMethod()) {

            default: // GET
                for (int i = 0; i < actionParameters.length; i++) {
                    Parameter actionParameter = actionParameters[i];
                    if (actionParameter.getType().equals(HttpServletRequest.class)) {
                        result[i] = request;
                    } else if (actionParameter.getType().equals(HttpServletResponse.class)) {
                        result[i] = response;
                    } else {
                        result[i] = request.getParameter(actionParameter.getName());
                    }
                }
        }
        return result;
    }
}
