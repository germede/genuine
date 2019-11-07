package org.fluentness.service.router;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.injection.InjectionService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultRouterService implements RouterService {

    private InjectionService manager;

    public DefaultRouterService(InjectionService manager) {
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
        Method method = action.getMethod();
        method.setAccessible(true);
        Class<?> returnType = method.getReturnType();
        if (returnType.equals(String.class)) {
            return (request, response) -> response.getWriter().write(
                (String) method.invoke(controller, mapParameters(method, request))
            );

        } else if (returnType.equals(Integer.class) || returnType.equals(Integer.TYPE)) {
            return (request, response) -> response.setStatus(
                (Integer) method.invoke(controller, mapParameters(method, request))
            );

        } else if (returnType.equals(HttpStatusCode.class)) {
            return (request, response) -> response.setStatus(
                ((HttpStatusCode) method.invoke(controller, mapParameters(method, request))).toInt()
            );
        } else if (returnType.equals(WebView.class)) {
            return (request, response) -> response.getWriter().write(
                ((WebView) method.invoke(controller, mapParameters(method, request))).render()
            );
        } else if (returnType.equals(AbstractWebController.Response.class)) {
            return (request, response) -> ((AbstractWebController.Response) method.invoke(controller, mapParameters(method, request))).response(response);
        }
        return (request, response) -> method.invoke(controller, mapParameters(method, request));
    }

    private Object[] mapParameters(Method function, HttpServletRequest request) {
        Parameter[] actionParameters = function.getParameters();
        Object[] result = new Object[actionParameters.length];
        if (actionParameters.length > 0 && actionParameters[0].getType().equals(AbstractWebController.Request.class)) {
            result[0] = new AbstractWebController.Request(request);
        }
        return result;
    }
}
