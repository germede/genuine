package org.fluentness.service.router;

import org.fluentness.Fluentness;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.server.*;
import org.fluentness.controller.html.HtmlAttribute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Map;

import static org.fluentness.controller.AbstractWeb.ACTION_RESULT;
import static org.fluentness.controller.AbstractWeb.div;

public class DefaultRouter implements Router {

    private final Authentication authentication;
    private final Log log;
    private final Configuration configuration;

    private final Map<String, Method> routes;

    public DefaultRouter(Authentication authentication, Log log, Configuration configuration) {
        this.authentication = authentication;
        this.log = log;
        this.configuration = configuration;

        this.routes = AbstractWebController.pathMethodMap;
    }

    @Override
    public Response handle(Request request) {
        AbstractWebController.request.set(request);

        Response response;
        try {
            String path = request.getMethod() + " " + request.getUri().getPath();
            if (path.startsWith("GET /resources")) {
                response = handleStaticFile(request);
            } else if (routes.containsKey(path)) {
                response = authentication.authorize(request) ?
                    executeWebAction(routes.get(path), request) :
                    authentication.demandCredentials(request);
            } else {
                response = request.makeResponse(ResponseStatusCode.NOT_FOUND);
            }
        } catch (Throwable cause) {
            response = request.makeResponse(ResponseStatusCode.INTERNAL_SERVER_ERROR);
            log.error(cause);
        }

        // try to handle errors
        if (response.getCode() >= 400 && routes.containsKey("GET /" + response.getCode())) {
            response = executeWebAction(routes.get("GET /" + response.getCode()), request);
        }
        return response;
    }

    private Response handleStaticFile(Request request) throws IOException {
        String path = request.getUri().getPath().replace("/resources/", "");
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(path);
        if (resourceAsStream != null) {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    resourceAsStream,
                    StandardCharsets.UTF_8
                )
            );
            StringBuilder result = new StringBuilder();
            String line;
            while (true) {
                if (!((line = reader.readLine()) != null)) break;
                result.append(line);
            }
            return request.makeResponse(ResponseStatusCode.OK)
                .setBody(result.toString())
                .addHeader(
                    ResponseHeader.CONTENT_TYPE,
                    path.startsWith("css") ? "text/css" :
                        path.startsWith("js") ? "application/javascript" :
                            "image/png"
                );
        }
        return request.makeResponse(ResponseStatusCode.NOT_FOUND);
    }

    private Response executeWebAction(Method action, Request request) {
        AbstractWebController webController = Fluentness.getInstance(
            (Class<? extends AbstractWebController>) action.getDeclaringClass()
        );
        action.setAccessible(true);
        Object[] args = prepareArgs(action, request);
        Object returned = null;
        try {
            returned = action.getParameterCount() > 0 ?
                action.invoke(webController, args) :
                action.invoke(webController);
            if (returned instanceof CharSequence) {
                return handleWebView(request, webController, (CharSequence) returned);
            } else if (returned instanceof Integer) {
                return request.makeResponse((int) returned);
            } else if (returned instanceof Response) {
                return (Response) returned;
            }
            return request.makeResponse(ResponseStatusCode.NOT_IMPLEMENTED);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e);
        }
        return request.makeResponse(ResponseStatusCode.INTERNAL_SERVER_ERROR);
    }

    private static Object[] prepareArgs(Method action, Request request) {
        Parameter[] parameters = action.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Class<?> type = parameter.getType();
            String name = parameter.getName();

            if (Request.class.isAssignableFrom(type)) {
                result[i] = request;
            } else if (type.equals(String.class)) {
                result[i] = request.hasParameter(name) ? request.getParameter(name) : "";
            } else if (int.class.isAssignableFrom(type)) {
                result[i] = request.hasParameter(name) ? Integer.parseInt(request.getParameter(name)) : 0;
            } else if (float.class.isAssignableFrom(type)) {
                result[i] = request.hasParameter(name) ? Float.parseFloat(request.getParameter(name)) : 0.0f;
            } else if (boolean.class.isAssignableFrom(type)) {
                result[i] = request.hasParameter(name) ? Boolean.parseBoolean(request.getParameter(name)) : false;
            } else if (Date.class.isAssignableFrom(type)) {
                result[i] = request.hasParameter(name) ? Date.parse(request.getParameter(name)) : new Date(0);
            }
        }
        return result;
    }

    private Response handleWebView(Request request, AbstractWebController webController, CharSequence returned) {
        String render;
        // todo fix translation

        if (request.getHeader(RequestHeader.X_REQUESTED_WITH) != null) {
            render = returned.toString();
        } else {
            render = webController.getWeb().getWebView().toString();
            if (configuration.get(SINGLE_PAGE_MODE)) {
                render = render
                    .replace("</head>", configuration.get(AJAX_HANDLER) + "</head>")
                    .replace(ACTION_RESULT, div(HtmlAttribute.ID + "ajax-placeholder", returned.toString()))
                ;
            } else {
                render = render.replace(ACTION_RESULT, returned.toString());
            }
        }
        return request
            .makeResponse(ResponseStatusCode.OK)
            .setBody(render)
            .addHeader(ResponseHeader.CONTENT_TYPE, "text/html; charset=" + configuration.get(RESPONSE_ENCODING));
    }
}
