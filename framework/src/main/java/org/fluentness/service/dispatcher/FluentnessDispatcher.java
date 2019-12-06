package org.fluentness.service.dispatcher;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.AbstractWebController.Authentication;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.logger.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static org.fluentness.controller.web.html.HtmlFactory._id;
import static org.fluentness.controller.web.html.HtmlFactory.div;
import static org.fluentness.service.server.Server.server_response_encoding;
import static org.fluentness.service.server.Server.server_single_page_mode;

public class FluentnessDispatcher extends HttpServlet implements Dispatcher {

    private static final String GET_RESOURCES = "GET /resources";
    private static final String AJAX_HANDLER = "<script src=\"/resources/js/ajax-handler.js\"></script>";

    private final Injector injector;
    private final Logger logger;

    private final Map<String, Method> routes;
    private final Map<Class, Authenticator> authenticators;
    private final boolean single_page_mode;
    private final String response_encoding;

    public FluentnessDispatcher(Injector injector, Configurator configurator, Logger logger) {
        this.injector = injector;
        this.logger = logger;
        this.routes = AbstractWebController.getRoutes();
        this.authenticators = injector.getInstances(Authenticator.class)
            .stream().collect(Collectors.toMap(Authenticator::getClass, o -> o));
        this.single_page_mode = configurator.getOrDefault(server_single_page_mode, true);
        this.response_encoding = configurator.getOrDefault(server_response_encoding, "UTF-8");
    }

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Request request = new Request(httpServletRequest);
        try {
            Locale.setDefault(request.getLocale());
            httpServletResponse.setCharacterEncoding(response_encoding);
            handlePath(request).response(httpServletResponse);
        } catch (Exception e) {
            logger.error(e);
            httpServletResponse.setStatus(500);
        } finally {
            if (httpServletResponse.getStatus() >= 400) {
                // custom error handling
                String path = request.getMethod() + " /" + httpServletResponse.getStatus();
                if (routes.containsKey(path)) {
                    authenticateWebAction(routes.get(path), request);
                }
            }
            logger.debug(
                "%s %s -> %s",
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI(),
                httpServletResponse.getStatus()
            );
        }
    }

    private Response handlePath(Request request) {
        String path = request.getMethod() + " " + request.getPathInfo();
        if (path.startsWith(GET_RESOURCES)) {
            return serveStaticResource(request);
        } else if (routes.containsKey(path)) {
            return authenticateWebAction(routes.get(path), request);
        }
        // route not found
        return response -> response.setStatus(404);
    }

    private Response serveStaticResource(Request request) {
        String resourcePath = request.getPathInfo().substring(11);
        if (resourcePath.startsWith("js") || resourcePath.startsWith("css")) {
            InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                // static resource not found
                return response -> response.setStatus(404);
            }
            return response -> {
                OutputStream out = response.getOutputStream();
                byte[] buffer = new byte[100];
                int numBytesRead;
                while ((numBytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, numBytesRead);
                }
            };
        }
        // excepting js and css files, everything is forbidden
        return response -> response.setStatus(403);

    }

    private Response authenticateWebAction(Method action, Request request) {
        // todo cache
        Response authenticationResponse = action.isAnnotationPresent(Authentication.class) ?
            Arrays.stream(action.getAnnotation(Authentication.class).authenticators())
                .filter(authenticators::containsKey)
                .findFirst()
                .map(authenticator -> authenticators.get(authenticator).authenticate(request))
                .orElse(null) :
            null;

        if (authenticationResponse == null) {
            // authentication successful
            return executeWebAction(action, request);
        }
        return authenticationResponse;
    }


    private Response executeWebAction(Method action, Request request) {
        AbstractWebController controller = injector.getInstance(
            (Class<? extends AbstractWebController>) action.getDeclaringClass()
        );
        try {
            Object returned = action.invoke(controller, new Request(request));
            if (returned instanceof String) {
                return response -> response.getWriter().write((String) returned);
            } else if (returned instanceof WebView) {
                WebView partial = (WebView) returned;
                String render;
                if (request.getHeader("http_x_requested_with") != null) {
                    // ajax request
                    render = partial.render();
                } else {

                    // main request
                    if (single_page_mode) {
                        render = controller
                            .getWeb().getView(div(_id("ajax-placeholder"), partial)).render();
                        render = render.replace("</head>", AJAX_HANDLER + "</head>");
                    } else {
                        render = controller.getWeb().getView(partial).render();
                    }
                }
                String finalRender = render;
                return response -> response.getWriter().write(finalRender);
            } else if (returned instanceof Integer) {
                return response -> response.setStatus((Integer) returned);
            } else if (returned instanceof Response) {
                return (Response) returned;
            }
            // not supported return type
            return response -> response.setStatus(500);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error(e);
        }
        return response -> response.setStatus(500);
    }

}
