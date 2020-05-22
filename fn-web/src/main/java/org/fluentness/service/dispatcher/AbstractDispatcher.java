package org.fluentness.service.dispatcher;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.log.Log;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDispatcher extends HttpServlet implements Dispatcher {

    protected final Authentication[] authentications;
    protected final Log log;

    public AbstractDispatcher(Authentication[] authentications, Log log) {
        this.authentications = authentications;
        this.log = log;
    }

    protected final Map<String, Method> routes = new HashMap<>();
    protected final Map<Method, AbstractWebController> controllers = new HashMap<>();

    @Override
    public final void addRoute(String method, String path, Method action, AbstractWebController controller) {
        routes.put(method + " " + getUrlPattern().replace("/*", "") + path, action);
        controllers.put(action, controller);
    }

    @Override
    protected final void service(HttpServletRequest request, final HttpServletResponse response) throws IOException {
        try {
            String path = request.getMethod() + " " + request.getRequestURI();
            if (routes.containsKey(path)) {
                boolean isAuthorized = true;
                for (Authentication authentication : authentications) {
                    if (!authentication.authorize(request)) {
                        authentication.demandCredentials(response);
                        isAuthorized = false;
                        break;
                    }
                }
                if (isAuthorized) {
                    dispatch(request, response);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Throwable cause) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.error(cause);
        }
        log.debug("%s %s -> %s", request.getMethod(), request.getRequestURI(), response.getStatus());
    }

    protected abstract void dispatch(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
