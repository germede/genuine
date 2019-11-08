package org.fluentness.service.router;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.injection.InjectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fluentness.service.configuration.ConfigurationService.router_encoding;

public class DefaultRouterService implements RouterService {

    private InjectionService injectionService;
    private ConfigurationService configurationService;

    public DefaultRouterService(InjectionService injectionService, ConfigurationService configurationService) {
        this.injectionService = injectionService;
        this.configurationService = configurationService;
    }

    private Map<String, HttpHandler> routingMap;

    @Override
    public Map<String, HttpHandler> getRoutingMap() {
        if (routingMap != null) {
            return routingMap;
        }
        routingMap = new HashMap<>();
        List<AbstractWebController> webControllers = injectionService.getInstances(AbstractWebController.class);
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
            return (request, response) -> {
                prepareResponse(response);
                response.getWriter().write(
                    (String) method.invoke(controller, mapParameters(method, request))
                );
            };
        } else if (returnType.equals(Integer.class) || returnType.equals(Integer.TYPE)) {
            return (request, response) -> {
                prepareResponse(response);
                response.setStatus(
                    (Integer) method.invoke(controller, mapParameters(method, request))
                );
            };

        } else if (returnType.equals(HttpStatusCode.class)) {
            return (request, response) -> {
                prepareResponse(response);
                response.setStatus(
                    ((HttpStatusCode) method.invoke(controller, mapParameters(method, request))).toInt()
                );
            };
        } else if (returnType.equals(WebView.class)) {
            return (request, response) -> {
                prepareResponse(response);
                response.getWriter().write(
                    ((WebView) method.invoke(controller, mapParameters(method, request))).render()
                );
            };
        } else if (returnType.equals(AbstractWebController.Response.class)) {
            return (request, response) -> {
                prepareResponse(response);
                ((AbstractWebController.Response) method.invoke(controller, mapParameters(method, request))).response(response);
            };
        }
        return (request, response) -> {
            prepareResponse(response);
            method.invoke(controller, mapParameters(method, request));
        };
    }

    private void prepareResponse(HttpServletResponse response) {
        response.setCharacterEncoding(configurationService.has(router_encoding) ? configurationService.get(router_encoding) : "UTF-8");
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
