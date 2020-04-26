package org.fluentness.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fluentness.Fluentness;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.controller.web.template.html.HtmlAttribute;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.translator.Translator;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.fluentness.controller.web.template.html.HtmlFactory.div;

public class SunServer implements Server {

    private final Log log;
    private final Configuration configuration;
    private final Authentication authentication;
    private final Translator translator;

    public SunServer(Authentication authentication, Configuration configuration, Log log, Translator translator) {
        this.log = log;
        this.configuration = configuration;
        this.authentication = authentication;
        this.translator = translator;
    }

    private HttpServer server;
    private Map<String, Method> routes;

    @Override
    public void start() throws IOException {
        this.routes = AbstractWebController.pathMethodMap;
        server = HttpServer.create(new InetSocketAddress(configuration.get(HOST), configuration.get(PORT)), 0);
        server.createContext("/", this::handle);
        log.info("Server listening to http://localhost:%s%s", configuration.get(PORT), configuration.get(CONTEXT));
        server.start();
    }

    @Override
    public void stop() {
        if (server != null) {
            server.stop(0);
        }
    }

    private void handle(HttpExchange exchange) throws IOException {
        try {
            Request request = new SunRequest(exchange);
            Request.CURRENT.set(request);
            AbstractWebController.request.set(request);

            Response response = handlePath(request);

            String body = response.getBody();
            String encoding = configuration.get(RESPONSE_ENCODING);
            exchange.sendResponseHeaders(response.getCode(), body.getBytes().length);
            Writer out = new OutputStreamWriter(exchange.getResponseBody(), encoding);
            out.write(body);
            out.close();
            log.debug("%s %s -> %s", request.getMethod(), request.getUri(), response.getCode());
        } catch (Exception e) {
            exchange.sendResponseHeaders(500, 0);
            log.error(e);
        }
    }

    private Response handlePath(Request request) throws IOException {
        String path = request.getMethod() + " " + request.getUri().getPath();
        if (path.startsWith("GET /resources")) {
            return handleStaticFile(request);
        } else if (routes.containsKey(path)) {
            return authenticateWebAction(routes.get(path), request);
        }
        return request.makeResponse(404);
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
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return request.makeResponse(200)
                .setBody(result.toString())
                .addHeader(
                    RequestHeader.CONTENT_TYPE,
                    path.startsWith("css") ? "text/css" :
                        path.startsWith("js") ? "application/javascript" :
                            "image/png"
                );
        }
        return request.makeResponse(404);
    }

    private Response authenticateWebAction(Method action, Request request) {
        if (action.getAnnotation(AbstractWebController.Action.class).authenticate() && !authentication.authenticate(request)) {
            return request.makeResponse(403);
        }
        return executeWebAction(action, request);
    }

    private Response executeWebAction(Method action, Request request) {
        AbstractWebController webController = Fluentness.getInstance((Class<? extends AbstractWebController>) action.getDeclaringClass());
        try {
            action.setAccessible(true);
            Object returned = action.getParameterCount() > 0 ? action.invoke(webController, prepareArgs(action, request)) : action.invoke(webController);
            if (returned instanceof String) {
                return request.makeResponse(200).setBody((String) returned);
            } else if (returned instanceof WebTemplate) {
                return handleWebView(request, webController, (WebTemplate) returned);
            } else if (returned instanceof Integer) {
                return request.makeResponse((int) returned);
            } else if (returned instanceof Response) {
                return (Response) returned;
            }
            return request.makeResponse(501);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e);
        }
        return request.makeResponse(500);
    }

    private Object prepareArgs(Method action, Request request) {
        Object[] result = new Object[action.getParameterCount()];
        Class<?>[] parameterTypes = action.getParameterTypes();
        for (int i = 0, parameterTypesLength = parameterTypes.length; i < parameterTypesLength; i++) {
            Class<?> parameterType = parameterTypes[i];
            // todo assign params
        }
        return result;
    }

    private Response handleWebView(Request request, AbstractWebController webController, WebTemplate returned) {
        String render;
        if (request.getHeaders().get(RequestHeader.X_REQUESTED_WITH) != null) {
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
            .makeResponse(200)
            .setBody(render)
            .addHeader(ResponseHeader.CONTENT_TYPE, "text/html; charset=" + configuration.get(RESPONSE_ENCODING));
    }
}
