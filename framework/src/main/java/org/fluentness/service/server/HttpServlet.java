package org.fluentness.service.server;

import org.fluentness.service.localization.LocalizationService;
import org.fluentness.service.logger.LoggerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class HttpServlet extends javax.servlet.http.HttpServlet {

    private LoggerService loggerService;
    private LocalizationService localizationService;

    private Map<String, HttpHandler> routing;

    public HttpServlet(LoggerService loggerService, LocalizationService localizationService) {
        this.loggerService = loggerService;
        this.localizationService = localizationService;
    }

    public void setRouting(Map<String, HttpHandler> routing) {
        this.routing = routing;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loggerService.debug(req.getMethod() + " " + req.getPathInfo());
        localizationService.setCurrentLocale(req.getLocale());
        super.service(req, resp);
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
