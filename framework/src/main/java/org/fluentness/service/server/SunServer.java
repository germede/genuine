package org.fluentness.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fluentness.Fluentness;
import org.fluentness.controller.web.Controller;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;

import static org.fluentness.controller.web.template.html.HtmlFactory.div;
import static org.fluentness.service.translator.Language.ID;

public class SunServer implements Server {

    private final Logger logger;
    private final Configurator configurator;
    private final Authenticator authenticator;

    public SunServer(Authenticator authenticator, Configurator configurator, Logger logger) {
        this.logger = logger;
        this.configurator = configurator;
        this.authenticator = authenticator;
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
            SunRequest request = new SunRequest(exchange);
            SunResponse response = handlePath(request);

            String body = response.getBody();
            String encoding = configurator.get(RESPONSE_ENCODING);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=" + encoding);
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

    private SunResponse handlePath(SunRequest request) throws IOException {
        String path = request.getMethod() + " " + request.getUri().getPath();
        if (path.startsWith(configurator.get(GET_RESOURCES))) {
            return handleStaticFiles(request);
        } else if (routes.containsKey(path)) {
            return authenticateWebAction(routes.get(path), request);
        }
        return request.response(404);
    }

    private SunResponse handleStaticFiles(SunRequest request) throws IOException {
        String resourcePath = request.getUri().getPath().substring(11);
        if (resourcePath.startsWith("js") || resourcePath.startsWith("css")) {
            Path path = Paths.get(resourcePath);
            if (!Files.exists(path)) {
                return request.response(404);
            } else {
                return request.response(200).setBody(Files.readAllLines(path).toString());
            }
        }

        return request.response(403);
    }

    private SunResponse authenticateWebAction(Method action, SunRequest request) {
        if (action.getAnnotation(Controller.Action.class).authenticate() && !authenticator.authenticate(request)) {
            return request.response(403);
        }
        return executeWebAction(action, request);
    }

    private SunResponse executeWebAction(Method action, SunRequest request) {
        Locale.setDefault(request.getLocale());
        Controller controller = Fluentness.getInstance((Class<? extends Controller>) action.getDeclaringClass());
        try {
            action.setAccessible(true);
            Object returned = action.getParameterCount() > 0 ? action.invoke(controller, calculateParams(action, request)) : action.invoke(controller);
            if (returned instanceof String) {
                return request.response(200).setBody((String) returned);
            } else if (returned instanceof WebTemplate) {
                return handleWebView(request, controller, (WebTemplate) returned);
            } else if (returned instanceof Integer) {
                return request.response((int) returned);
            } else if (returned instanceof SunResponse) {
                return (SunResponse) returned;
            }
            return request.response(501);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error(e);
        }
        return request.response(500);
    }

    private Object calculateParams(Method action, SunRequest request) {
        Object[] result = new Object[action.getParameterCount()];
        Class<?>[] parameterTypes = action.getParameterTypes();
        for (int i = 0, parameterTypesLength = parameterTypes.length; i < parameterTypesLength; i++) {
            Class<?> parameterType = parameterTypes[i];
            // todo assign params
        }
        return result;
    }

    private SunResponse handleWebView(SunRequest request, Controller controller, WebTemplate returned) {
        String render;
        if (request.getHeaders().get("http_x_requested_with") != null) {
            render = returned.render();
        } else {
            if (configurator.get(SINGLE_PAGE_MODE)) {
                render = controller
                    .getWeb().getTemplate(div(ID + "ajax-placeholder", returned.toString())).render();
                render = render.replace("</head>", configurator.get(AJAX_HANDLER) + "</head>");
            } else {
                render = controller.getWeb().getTemplate(returned.toString()).render();
            }
        }
        return request.response(200).setBody(render);
    }
}
