package org.fluentness.service.routing;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.authentication.AuthenticationService;
import org.fluentness.service.caching.CachingService;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.injection.InjectionService;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fluentness.service.configuration.ConfigurationService.router_encoding;

public class DefaultRoutingService implements RoutingService {

    private final InjectionService injectionService;
    private final ConfigurationService configurationService;
    private final AuthenticationService authenticationService;
    private final CachingService cachingService;

    public DefaultRoutingService(InjectionService injectionService,
                                 ConfigurationService configurationService,
                                 AuthenticationService authenticationService,
                                 CachingService cachingService) {
        this.injectionService = injectionService;
        this.configurationService = configurationService;
        this.authenticationService = authenticationService;
        this.cachingService = cachingService;
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
            List<WebAction> actions = controller.getActions();
            actions.forEach(action -> routingMap.put(action.getPath(), getHttpHandlerForAction(controller, action)));
        });
        return routingMap;
    }

    private HttpHandler getHttpHandlerForAction(AbstractWebController controller, WebAction action) {
        Method method = action.getMethod();
        method.setAccessible(true);
        return (request, response) -> {
            if (!request.getMethod().equals(action.getHttpMethod())) {
                response.setStatus(405);
            } else if (!action.isAuthentication() || authenticationService.authenticate(request, response)) {
                response.setCharacterEncoding(configurationService.getOrDefault(router_encoding, "UTF-8"));
                // todo cache
                Object returnValue = method.invoke(controller, new AbstractWebController.Request(request));
                if (returnValue instanceof String) {
                    response.getWriter().write((String) returnValue);
                } else if (returnValue instanceof WebView) {
                    response.getWriter().write(((WebView) returnValue).render());
                } else if (returnValue instanceof Integer) {
                    response.setStatus((Integer) returnValue);
                } else if (returnValue instanceof AbstractWebController.Response) {
                    ((AbstractWebController.Response) returnValue).response(response);
                }
            }

        };
    }
}
