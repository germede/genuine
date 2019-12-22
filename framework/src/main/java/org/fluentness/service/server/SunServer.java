package org.fluentness.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.view.HtmlView;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injector.Injector;
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
import java.util.stream.Collectors;

import static org.fluentness.controller.web.view.HtmlFactory._id;
import static org.fluentness.controller.web.view.HtmlFactory.div;

public class SunServer implements Server {

    private static final String GET_RESOURCES = "GET /resources";
    private static final String AJAX_HANDLER = "<script src=\"/resources/js/ajax-handler.js\"></script>";

    private final Logger logger;
    private final Injector injector;

    private final int port;
    private final String context;
    private final String response_encoding;
    private final boolean single_page_mode;

    private final Map<String, Method> routes;
    private final Map<Class, Authenticator> authenticators;

    private final HttpServer server;

    public SunServer(Injector injector, Configuration configuration, Logger logger) throws IOException {
        this.injector = injector;
        this.logger = logger;

        this.port = configuration.get(Server.PORT);
        this.context = configuration.get(Server.CONTEXT);
        this.response_encoding = configuration.get(Server.RESPONSE_ENCODING);
        this.single_page_mode = configuration.get(Server.SINGLE_PAGE_MODE);

        this.routes = AbstractWebController.getRoutes();
        this.authenticators = injector.getInstances(Authenticator.class)
            .stream().collect(Collectors.toMap(Authenticator::getClass, o -> o));

        this.server = HttpServer.create(new InetSocketAddress(8000), 0);
        this.server.createContext(context).setHandler(this::handle);
    }


    @Override
    public void start() {
        logger.info("Server listening to http://localhost:%s%s", port, context);
        server.start();
    }

    @Override
    public void stop() {
        server.stop(0);
    }

    private void handle(HttpExchange exchange) throws IOException {
        Request request = new Request(exchange);
        Response response;
        try {
            response = handlePath(request);
        } catch (Exception e) {
            response = request.response(500);
            logger.error(e);
        }


        //        if (httpServletResponse.getStatus() >= 400) {
//            // custom error handling
//            String path = request.getMethod() + " /" + httpServletResponse.getStatus();
//            if (routes.containsKey(path)) {
//                authenticateWebAction(routes.get(path), request);
//            }
//        }

        String body = response.getBody();
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=" + response_encoding);
        exchange.sendResponseHeaders(response.getCode(), body.getBytes().length);
        Writer out = new OutputStreamWriter(exchange.getResponseBody(), response_encoding);
        out.write(body);
        out.close();
        logger.debug("%s %s -> %s", request.getMethod(), request.getUri(), response.getCode());
    }

    private Response handlePath(Request request) throws IOException {
        String path = request.getMethod() + " " + request.getUri().getPath();
        if (path.startsWith(GET_RESOURCES)) {
            return handleStaticFiles(request);
        } else if (routes.containsKey(path)) {
            return authenticateWebAction(routes.get(path), request);
        }
        return request.response(404);
    }

    private Response handleStaticFiles(Request request) throws IOException {
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

    private Response authenticateWebAction(Method action, Request request) {
        if (action.isAnnotationPresent(AbstractWebController.Authentication.class)) {
            for (Class<? extends Authenticator> authenticator :
                action.getAnnotation(AbstractWebController.Authentication.class).authenticators()) {
                if (authenticators.containsKey(authenticator)) {
                    if (authenticators.get(authenticator).authenticate(request)) {
                        return request.response(403);
                    }
                }
            }
        }
        // todo cache
        return executeWebAction(action, request);
    }

    private Response executeWebAction(Method action, Request request) {
        Locale.setDefault(request.getLocale());

        AbstractWebController<?> controller = injector.getInstance(
                (Class<AbstractWebController<?>>) action.getDeclaringClass()
        );

        try {
            Object returned = action.invoke(controller, request);
            if (returned instanceof String) {
                return request.response(200).setBody((String) returned);
            } else if (returned instanceof HtmlView) {
                return handleWebView(request, controller, (HtmlView) returned);
            } else if (returned instanceof Integer) {
                return request.response((int) returned);
            } else if (returned instanceof Response) {
                return (Response) returned;
            }
            return request.response(501);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error(e);
        }
        return request.response(500);
    }

    private Response handleWebView(Request request, AbstractWebController<?> controller, HtmlView returned) {
        String render;
        if (request.getHeaders().get("http_x_requested_with") != null) {
            render = returned.render();
        } else {
            if (single_page_mode) {
                render = controller
                    .getWeb().getView(div(_id("ajax-placeholder"), returned)).render();
                render = render.replace("</head>", AJAX_HANDLER + "</head>");
            } else {
                render = controller.getWeb().getView(returned).render();
            }
        }
        return request.response(200).setBody(render);
    }
}
