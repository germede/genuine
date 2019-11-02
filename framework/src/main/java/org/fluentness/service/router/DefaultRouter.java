package org.fluentness.service.router;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.manager.Manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultRouter implements Router {

    private Manager manager;

    public DefaultRouter(Manager manager) {
        this.manager = manager;
    }

    private Map<String, HttpHandler> routingMap;

    @Override
    public Map<String, HttpHandler> getRoutingMap() {
        if (routingMap != null) {
            return routingMap;
        }
        routingMap = new HashMap<>();
        List<AbstractWebController> webControllers = manager.getInstances(AbstractWebController.class);
        webControllers.forEach(controller -> {
            controller.getActions().forEach(action -> {
                routingMap.put(action.getPath(), getHttpHandlerForAction(controller, action));
            });
        });
        return routingMap;
    }

    private HttpHandler getHttpHandlerForAction(AbstractWebController controller, WebAction action) {
        Method function = action.getMethod();
        Class<?> returnType = function.getReturnType();
        if (returnType.equals(String.class)) {
            return (request, response) -> response.getWriter().write(
                (String) function.invoke(controller, mapParameters(function, request, response))
            );

        } else if (returnType.equals(Integer.class) || returnType.equals(Integer.TYPE)) {
            return (request, response) -> response.setStatus(
                (Integer) function.invoke(controller, mapParameters(function, request, response))
            );

        } else if (returnType.equals(HttpStatusCode.class)) {
            return (request, response) -> response.setStatus(
                ((HttpStatusCode) function.invoke(controller, mapParameters(function, request, response))).toInt()
            );
        } else if (returnType.equals(WebView.class)) {
            return (request, response) -> response.getWriter().write(
                ((WebView) function.invoke(controller, mapParameters(function, request, response))).render()
            );
        }
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
