package org.fluentness.service.routing;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.dependency.DependencyService;
import org.fluentness.service.server.HttpHandler;
import org.fluentness.service.server.HttpStatusCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultRoutingService implements RoutingService {

    private DependencyService dependencyService;
    private Method function;

    public DefaultRoutingService(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
    }

    @Override
    public Map<String, HttpHandler> getRoutingMap() {
        List<AbstractWebController> webControllers = dependencyService.getInstances(AbstractWebController.class);
        Map<String, HttpHandler> result = new HashMap<>();
        webControllers.forEach(controller -> {
            controller.getActions().forEach(action -> {
                result.put(action.getPath(), getHttpHandlerForAction(controller, action));
            });
        });
        return result;
    }

    private HttpHandler getHttpHandlerForAction(AbstractWebController controller, WebAction action) {
        function = action.getMethod();
        Class<?> returnType = function.getReturnType();
        if (returnType.equals(String.class)) {
            return (request, response) -> response.getWriter().write((String) function.invoke(controller, mapParameters(function, request, response)));
        } else if (returnType.equals(Integer.class) || returnType.equals(Integer.TYPE)) {
            return (request, response) -> response.setStatus((Integer) function.invoke(controller, mapParameters(function, request, response)));
        } else if (returnType.equals(HttpStatusCode.class)) {
            return (request, response) -> response.setStatus(((HttpStatusCode) function.invoke(controller, mapParameters(function, request, response))).toInt());
        } else if (returnType.equals(WebView.class)) {
            return (request, response) -> response.getWriter().write(((WebView) function.invoke(controller, mapParameters(function, request, response))).render());
        }
        // ignore return value
        return (request, response) -> function.invoke(controller, mapParameters(function, request, response));
    }

    private Object[] mapParameters(Method function, HttpServletRequest request, HttpServletResponse response) {
        Parameter[] actionParameters = function.getParameters();
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
