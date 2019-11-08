package org.fluentness.service.router;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.authentication.AuthenticationService;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.injection.InjectionService;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fluentness.service.configuration.ConfigurationService.router_encoding;

public class DefaultRouterService implements RouterService {

    private final InjectionService injectionService;
    private final ConfigurationService configurationService;
    private final AuthenticationService authenticationService;

    public DefaultRouterService(InjectionService injectionService, ConfigurationService configurationService, AuthenticationService authenticationService) {
        this.injectionService = injectionService;
        this.configurationService = configurationService;
        this.authenticationService = authenticationService;
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
        final Method method = action.getMethod();
        method.setAccessible(true);
        return (request, response) -> {
            if (!request.getMethod().equals(action.getHttpMethod().toString())) {
                response.setStatus(HttpStatusCode.METHOD_NOT_ALLOWED.toInt());
            } else if (authenticationService.authenticate(request, response)) {
                response.setCharacterEncoding(
                    configurationService.has(router_encoding) ? configurationService.get(router_encoding) : "UTF-8"
                );

                boolean hasRequestParameter = (action.getMethod().getParameters().length > 0 &&
                    action.getMethod().getParameters()[0].getType().equals(AbstractWebController.Request.class)
                );
                Object returnValue = method.invoke(controller, hasRequestParameter ?
                    new Object[]{new AbstractWebController.Request(request)} :
                    null
                );

                if (returnValue instanceof String) {
                    response.getWriter().write((String) returnValue);
                } else if (returnValue instanceof Integer) {
                    response.setStatus((Integer) returnValue);
                } else if (returnValue instanceof HttpStatusCode) {
                    response.setStatus(((HttpStatusCode) returnValue).toInt());
                } else if (returnValue instanceof WebView) {
                    response.getWriter().write(((WebView) returnValue).render());
                } else if (returnValue instanceof AbstractWebController.Response) {
                    ((AbstractWebController.Response) returnValue).response(response);
                }
            }
        };
    }


}
