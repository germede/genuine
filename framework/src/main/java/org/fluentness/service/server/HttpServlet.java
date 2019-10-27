package org.fluentness.service.server;

import org.fluentness.service.logger.LoggerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

class HttpServlet extends javax.servlet.http.HttpServlet {

    private LoggerService loggerService;
    private Map<String, HttpHandler> routing;

    HttpServlet(LoggerService loggerService, Map<String, HttpHandler> routing) {
        this.loggerService = loggerService;
        this.routing = routing;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (routing.containsKey(request.getPathInfo())) {
            try {
                routing.get(request.getPathInfo()).handle(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                loggerService.error(e);
            }
        }
    }

    //todo support other methods
}
