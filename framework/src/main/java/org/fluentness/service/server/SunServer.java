package org.fluentness.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fluentness.Fluentness;
import org.fluentness.controller.web.Controller;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.controller.web.template.html.HtmlAttribute;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.translator.Translator;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.fluentness.controller.web.template.html.HtmlFactory.div;

public class SunServer implements Server {

    private final Logger logger;
    private final Configurator configurator;
    private final Authenticator authenticator;
    private final Translator translator;

    public SunServer(Authenticator authenticator, Configurator configurator, Logger logger, Translator translator) {
        this.logger = logger;
        this.configurator = configurator;
        this.authenticator = authenticator;
        this.translator = translator;
    }

    private HttpServer server;
    private Map<String, Method> routes;

    @Override
    public void start(Map<String, Method> routes) throws IOException {
        this.routes = routes;
        server = HttpServer.create(new InetSocketAddress(configurator.get(HOST), configurator.get(PORT)), 0);
        server.createContext("/", this::handle);
        logger.info("Server listening to http://localhost:%s%s", configurator.get(PORT), configurator.get(CONTEXT));
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
            Response response = handlePath(request);

            String body = response.getBody();
            String contentType = "text/html";
            String encoding = configurator.get(RESPONSE_ENCODING);
            response.getHeaders().set(ResponseHeader.CONTENT_TYPE, contentType + "; charset=" + encoding);
            exchange.sendResponseHeaders(response.getCode(), body.getBytes().length);
            Writer out = new OutputStreamWriter(exchange.getResponseBody(), encoding);
            out.write(body);
            out.close();
            logger.debug("%s %s -> %s", request.getMethod(), request.getUri(), response.getCode());
        } catch (Exception e) {
            exchange.sendResponseHeaders(500, 0);
            logger.error(e);
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
        if (action.getAnnotation(Controller.Action.class).authenticate() && !authenticator.authenticate(request)) {
            return request.makeResponse(403);
        }
        return executeWebAction(action, request);
    }

    private Response executeWebAction(Method action, Request request) {
        Controller controller = Fluentness.getInstance((Class<? extends Controller>) action.getDeclaringClass());
        try {
            action.setAccessible(true);
            Object returned = action.getParameterCount() > 0 ? action.invoke(controller, prepareArgs(action, request)) : action.invoke(controller);
            if (returned instanceof String) {
                return request.makeResponse(200).setBody((String) returned);
            } else if (returned instanceof WebTemplate) {
                return handleWebView(request, controller, (WebTemplate) returned);
            } else if (returned instanceof Integer) {
                return request.makeResponse((int) returned);
            } else if (returned instanceof Response) {
                return (Response) returned;
            }
            return request.makeResponse(501);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error(e);
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

    private Response handleWebView(Request request, Controller controller, WebTemplate returned) {
        String render;
        if (request.getHeaders().get(RequestHeader.X_REQUESTED_WITH) != null) {
            render = returned.render();
        } else {
            if (configurator.get(SINGLE_PAGE_MODE)) {
                render = controller.getWeb().getTemplate(div(HtmlAttribute.ID + "ajax-placeholder", returned.toString())).render();
                render = render.replace("</head>", configurator.get(AJAX_HANDLER) + "</head>");
            } else {
                WebTemplate template = controller.getWeb().getTemplate(returned.toString());
                render = template.render();
            }
        }
        return request.makeResponse(200).setBody(render);
    }
}
