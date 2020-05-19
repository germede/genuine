package org.fluentness.service.router;

import org.fluentness.Fluentness;
import org.fluentness.controller.AbstractWeb;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.controller.html.HtmlAttribute;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.server.*;
import org.fluentness.service.translator.Translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.fluentness.service.server.ResponseMimeType.*;

public class RouterImpl implements Router {

    private final Authentication authentication;
    private final Log log;
    private final Configuration configuration;
    private final Translator translator;

    private final Map<String, Method> routes;

    public RouterImpl(Authentication authentication, Log log, Configuration configuration, Translator translator) {
        this.authentication = authentication;
        this.log = log;
        this.configuration = configuration;
        this.translator = translator;
        this.routes = AbstractWebController.pathMethodMap;
    }

    @Override
    public Response handle(Request request) {
        AbstractWebController.request.set(request);

        Response response;
        try {
            String path = request.getMethod() + " " + request.getUri();
            if (path.startsWith("GET /resources")) {
                response = handleStaticFile(request);
            } else if (routes.containsKey(path)) {
                response = authentication.authorize(request) ?
                    executeWebAction(routes.get(path), request) :
                    authentication.demandCredentials(request);
            } else {
                response = request.makeResponse(ResponseStatusCode.NOT_FOUND, ResponseMimeType.TEXT_HTML, "");
            }
            if (response.getStatusCode() >= 400 && routes.containsKey("GET /" + response.getStatusCode())) {
                response = executeWebAction(routes.get("GET /" + response.getStatusCode()), request);
            }
        } catch (Throwable cause) {
            response = request.makeResponse(
                ResponseStatusCode.INTERNAL_SERVER_ERROR,
                ResponseMimeType.TEXT_PLAIN,
                ResponseStatusCode.INTERNAL_SERVER_ERROR.toString()
            );
            log.error(cause);
        }
        return response;
    }

    private Response handleStaticFile(Request request) throws IOException {
        String path = request.getUri().replace("/resources/", "");
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
                if ((line = reader.readLine()) == null) break;
                result.append(line);
            }
            return request.makeResponse(
                ResponseStatusCode.OK,
                path.startsWith("css") ? TEXT_CSS : path.startsWith("js") ? APPLICATION_JAVASCRIPT : IMAGE_PNG,
                result.toString()
            );
        }
        return request.makeResponse(ResponseStatusCode.NOT_FOUND, ResponseMimeType.TEXT_HTML, "");
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
            } else if (returned instanceof Response) {
                return (Response) returned;
            }
            return request.makeResponse(
                ResponseStatusCode.NOT_IMPLEMENTED,
                ResponseMimeType.TEXT_PLAIN,
                ResponseStatusCode.NOT_IMPLEMENTED.toString()
            );
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e);
        }
        return request.makeResponse(
            ResponseStatusCode.INTERNAL_SERVER_ERROR,
            ResponseMimeType.TEXT_PLAIN,
            ResponseStatusCode.INTERNAL_SERVER_ERROR.toString()
        );
    }


    private Response handleWebView(Request request, AbstractWebController webController, CharSequence returned) {
        String render;
        if (returned instanceof String) {
            returned = translator.translate((String) returned, request.getLanguages());
        }

        if (request.getHeaders().containsKey(RequestHeader.X_REQUESTED_WITH)) {
            render = returned.toString();
        } else {
            render = webController.getWeb().getTemplate().toString();
            if (configuration.get(SINGLE_PAGE_MODE)) {
                render = render
                    .replace("</head>", configuration.get(AJAX_HANDLER) + "</head>")
                    .replace(AbstractWeb.ACTION_RESULT, AbstractWeb.div(HtmlAttribute.ID + "ajax-placeholder", returned.toString()))
                ;
            } else {
                render = render.replace(AbstractWeb.ACTION_RESULT, returned.toString());
            }
        }
        return request.makeResponse(
            ResponseStatusCode.OK,
            TEXT_HTML, // todo returned instanceof Xml,
            render
        );
    }
}
