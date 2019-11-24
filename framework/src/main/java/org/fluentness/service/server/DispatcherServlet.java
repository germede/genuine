package org.fluentness.service.server;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.logger.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static org.fluentness.controller.web.html.HtmlFactory.*;
import static org.fluentness.service.server.Server.server_response_encoding;
import static org.fluentness.service.server.Server.server_single_page_mode;

public class DispatcherServlet extends HttpServlet {

    private static final String GET_RESOURCES = "GET /resources";
    private static final String AJAX_HANDLER = "<script src=\"/resources/js/ajax-handler.js\"></script>";

    private final Logger logger;
    private final Map<String, WebAction> routes;
    private final Map<Class<? extends Authenticator>, Authenticator> authenticators;
    private final boolean single_page_mode;
    private final String response_encoding;

    public DispatcherServlet(Injector injector, Configurator configurator, Logger logger) {
        this.logger = logger;
        this.routes = AbstractWebController.getRoutes();
        List<Authenticator> instances = injector.getInstances(Authenticator.class);
        this.authenticators = instances
            .stream().collect(Collectors.toMap(Authenticator::getClass, o -> o));
        this.single_page_mode = configurator.getOrDefault(server_single_page_mode, true);
        this.response_encoding = configurator.getOrDefault(server_response_encoding, "UTF-8");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            Locale.setDefault(request.getLocale());
            response.setCharacterEncoding(response_encoding);
            handlePath(request, response);
        } catch (Exception e) {
            logger.error(e);
            response.setStatus(500);
        } finally {
            if (response.getStatus() >= 400) {
                handleError(request, response);
            }
        }
    }

    private void handlePath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getMethod() + " " + request.getPathInfo();
        if (path.startsWith(GET_RESOURCES)) {
            handleStaticResource(request, response);
        } else if (routes.containsKey(path)) {
            if (path.startsWith(request.getMethod())) {
                handleWebAction(routes.get(path), request, response);
            } else {
                response.setStatus(405);
            }
        } else {
            response.setStatus(404);
        }
    }

    private void handleStaticResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String resourcePath = request.getPathInfo().substring(GET_RESOURCES.length());
        if (resourcePath.startsWith("js") || resourcePath.startsWith("css")) {
            InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                response.setStatus(404);
                return;
            }
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[100];
            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }

    private void handleWebAction(WebAction action, HttpServletRequest request, HttpServletResponse response) {

        if (handleAuthentication(action, request, response)) {
            // todo cache
            try {
                Object returnValue = action.getLambda().execute(new AbstractWebController.Request(request));
                handleReturnValue(action, request, response, returnValue);
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    private boolean handleAuthentication(WebAction action, HttpServletRequest request, HttpServletResponse response) {
        if (!action.getLambda().isAnnotationPresent(AbstractWebController.Authentication.class)) {
            return true;
        }
        for (Class<? extends Authenticator> authenticator :
            action.getLambda().getAnnotation(AbstractWebController.Authentication.class).authenticators()) {
            if (authenticators.containsKey(authenticator)) {
                if (!authenticators.get(authenticator).authenticate(request, response)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void handleReturnValue(WebAction action,
                                   HttpServletRequest request,
                                   HttpServletResponse response,
                                   Object returnValue)
        throws IOException {

        if (returnValue instanceof String) {
            response.getWriter().write((String) returnValue);
        } else if (returnValue instanceof WebView) {
            WebView partial = (WebView) returnValue;
            String render;
            if (request.getHeader("http_x_requested_with") != null) {
                // ajax request
                render = partial.render();
            } else {
                // main request
                if (single_page_mode) {
                    render = action.getController().getWeb().view(div(_id("ajax-placeholder"), partial)).render();
                    render = render.replace("</head>", AJAX_HANDLER + "</head>");
                } else {
                    render = action.getController().getWeb().view(partial).render();
                }
            }
            response.getWriter().write(render);

        } else if (returnValue instanceof Integer) {
            response.setStatus((Integer) returnValue);
        } else if (returnValue instanceof AbstractWebController.Response) {
            ((AbstractWebController.Response) returnValue).response(response);
        }
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getMethod() + " /" + response.getStatus();
        if (routes.containsKey(path)) {
            // custom error code pages
            handleWebAction(routes.get(path), request, response);
        }
    }
}
