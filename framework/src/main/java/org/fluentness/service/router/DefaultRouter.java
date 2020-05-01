package org.fluentness.service.router;

import org.fluentness.Fluentness;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.controller.web.template.html.HtmlAttribute;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.server.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.fluentness.controller.web.template.html.HtmlFactory.div;

public class DefaultRouter implements Router {

    private final Authentication authentication;

    private final Map<String, Method> routes;
    private final Log log;
    private final Configuration configuration;

    public DefaultRouter(Authentication authentication, Log log, Configuration configuration) {
        this.authentication = authentication;
        this.log = log;
        this.configuration = configuration;

        this.routes = AbstractWebController.pathMethodMap;
    }

    @Override
    public Response handle(Request request) {
        AbstractWebController.request.set(request);

        try {
            String path = request.getMethod() + " " + request.getUri().getPath();
            if (path.startsWith("GET /resources")) {
                return handleStaticFile(request);
            } else if (routes.containsKey(path)) {
                return authentication.handle(request, () -> executeWebAction(routes.get(path), request));
            }
            return request.makeResponse(ResponseStatusCode.NOT_FOUND);
        } catch (Throwable cause) {
            log.error(cause);
        }
        return request.makeResponse(ResponseStatusCode.INTERNAL_SERVER_ERROR);
    }

    private Response handleStaticFile(Request request) {
        String path = request.getUri().getPath().replace("/resources/", "");
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(path);
        if (resourceAsStream != null) {
            try {
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
            } catch (IOException e) {
                log.error(e);
            }
        }
        return request.makeResponse(ResponseStatusCode.NOT_FOUND);
    }

    private Response executeWebAction(Method action, Request request) {
        AbstractWebController webController = Fluentness.getInstance(
            (Class<? extends AbstractWebController>) action.getDeclaringClass()
        );
        try {
            action.setAccessible(true);
            Object[] args = prepareArgs(action, request);
            Object returned = action.getParameterCount() > 0 ?
                action.invoke(webController, args) :
                action.invoke(webController);
            if (returned instanceof String) {
                return request.makeResponse(ResponseStatusCode.OK).setBody((String) returned);
            } else if (returned instanceof WebTemplate) {
                return handleWebView(request, webController, (WebTemplate) returned);
            } else if (returned instanceof Integer) {
                return request.makeResponse((int) returned);
            } else if (returned instanceof Response) {
                return (Response) returned;
            }
            return request.makeResponse(ResponseStatusCode.NOT_IMPLEMENTED);
        } catch (Throwable e) {
            log.error(e);
        }
        return request.makeResponse(ResponseStatusCode.INTERNAL_SERVER_ERROR);
    }

    private static Object[] prepareArgs(Method action, Request request) {
        Parameter[] parameters = action.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            if (Request.class.isAssignableFrom(parameter.getType())) {
                result[i] = request;
            } else if (int.class.isAssignableFrom(parameter.getType())) {
                try {
                    int integer = Integer.parseInt(request.getParameter(parameter.getName()));
                    result[i] = integer;
                } catch (NumberFormatException e) {
                    result[i] = 0;
                }
            } else if (String.class.isAssignableFrom(parameter.getType())) {
                result[i] = request.getParameter(parameter.getName());
            }
        }
        return result;
    }

    private Response handleWebView(Request request, AbstractWebController webController, WebTemplate returned) {
        String render;
        if (request.getHeader(RequestHeader.X_REQUESTED_WITH) != null) {
            render = returned.render();
        } else {
            if (configuration.get(SINGLE_PAGE_MODE)) {
                render = webController.view().getTemplate(div(HtmlAttribute.ID + "ajax-placeholder", returned.toString())).render();
                render = render.replace("</head>", configuration.get(AJAX_HANDLER) + "</head>");
            } else {
                WebTemplate template = webController.view().getTemplate(returned.toString());
                render = template.render();
            }
        }
        return request
            .makeResponse(ResponseStatusCode.OK)
            .setBody(render)
            .addHeader(ResponseHeader.CONTENT_TYPE, "text/html; charset=" + configuration.get(RESPONSE_ENCODING));
    }
}
