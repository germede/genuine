package org.fluentness.service.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

public class StaticServlet extends HttpServlet implements Servlet {

    private final Authentication authentication;
    private final Log log;
    private final Configuration configuration;

    private final Map<String, Method> routes;

    public StaticServlet(Authentication authentication, Log log, Configuration configuration) {
        this.authentication = authentication;
        this.log = log;
        this.configuration = configuration;

        this.routes = AbstractWebController.pathMethodMap;
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.println("<html><title>Welcome</title><body>");
        writer.println("<h1>Have a Great Day! I'm static</h1>");
        writer.println("</body></html>");;

//        AbstractWebController.request.set(request);
//
//        try {
//            String path = request.getMethod() + " " + request.getUri().getPath();
//            if (path.startsWith("GET /resources")) {
//                response = handleStaticFile(request);
//            } else if (routes.containsKey(path)) {
//                response = authentication.authorize(request) ?
//                    executeWebAction(routes.get(path), request) :
//                    authentication.demandCredentials(request);
//            } else {
//                response = request.makeResponse(ResponseStatusCode.NOT_FOUND);
//            }
//        } catch (Throwable cause) {
//            response = request.makeResponse(ResponseStatusCode.INTERNAL_SERVER_ERROR);
//            log.error(cause);
//        }
//
//        // try to handle errors
//        if (response.getCode() >= 400 && routes.containsKey("GET /" + response.getCode())) {
//            response = executeWebAction(routes.get("GET /" + response.getCode()), request);
//        }


    }
//
//    private Response handleStaticFile(Request request) throws IOException {
//        String path = request.getUri().getPath().replace("/resources/", "");
//        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(path);
//        if (resourceAsStream != null) {
//            BufferedReader reader = new BufferedReader(
//                new InputStreamReader(
//                    resourceAsStream,
//                    StandardCharsets.UTF_8
//                )
//            );
//            StringBuilder result = new StringBuilder();
//            String line;
//            while (true) {
//                if (!((line = reader.readLine()) != null)) break;
//                result.append(line);
//            }
//            return request.makeResponse(ResponseStatusCode.OK)
//                .setBody(result.toString())
//                .addHeader(
//                    ResponseHeader.CONTENT_TYPE,
//                    path.startsWith("css") ? "text/css" :
//                        path.startsWith("js") ? "application/javascript" :
//                            "image/png"
//                );
//        }
//        return request.makeResponse(ResponseStatusCode.NOT_FOUND);
//    }
//
//    private Response executeWebAction(Method action, Request request) {
//        AbstractWebController webController = null;
////        AbstractWebController webController = Fluentness.getInstance(
////            (Class<? extends AbstractWebController>) action.getDeclaringClass()
////        );
//        action.setAccessible(true);
//        Object[] args = prepareArgs(action, request);
//        Object returned = null;
//        try {
//            returned = action.getParameterCount() > 0 ?
//                action.invoke(webController, args) :
//                action.invoke(webController);
//            if (returned instanceof CharSequence) {
//                return handleWebView(request, webController, (CharSequence) returned);
//            } else if (returned instanceof Integer) {
//                return request.makeResponse((int) returned);
//            } else if (returned instanceof Response) {
//                return (Response) returned;
//            }
//            return request.makeResponse(ResponseStatusCode.NOT_IMPLEMENTED);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            log.error(e);
//        }
//        return request.makeResponse(ResponseStatusCode.INTERNAL_SERVER_ERROR);
//    }
//
//    private static Object[] prepareArgs(Method action, Request request) {
//        Parameter[] parameters = action.getParameters();
//        Object[] result = new Object[parameters.length];
//        for (int i = 0; i < parameters.length; i++) {
//            Parameter parameter = parameters[i];
//            Class<?> type = parameter.getType();
//            String name = parameter.getName();
//
//            if (Request.class.isAssignableFrom(type)) {
//                result[i] = request;
//            } else if (type.equals(String.class)) {
//                result[i] = request.hasParameter(name) ? request.getParameter(name) : "";
//            } else if (int.class.isAssignableFrom(type)) {
//                result[i] = request.hasParameter(name) ? Integer.parseInt(request.getParameter(name)) : 0;
//            } else if (float.class.isAssignableFrom(type)) {
//                result[i] = request.hasParameter(name) ? Float.parseFloat(request.getParameter(name)) : 0.0f;
//            } else if (boolean.class.isAssignableFrom(type)) {
//                result[i] = request.hasParameter(name) && Boolean.parseBoolean(request.getParameter(name));
//            } else if (Date.class.isAssignableFrom(type)) {
//                result[i] = request.hasParameter(name) ? Date.parse(request.getParameter(name)) : new Date(0);
//            }
//        }
//        return result;
//    }
//
//    private Response handleWebView(Request request, AbstractWebController webController, CharSequence returned) {
//        String render;
//        if (request.getHeader(RequestHeader.X_REQUESTED_WITH) != null) {
//            render = returned.toString();
//        } else {
//            render = webController.getWebView().toString();
//            if (configuration.get(SINGLE_PAGE_MODE)) {
//                render = render
//                    .replace("</head>", configuration.get(AJAX_HANDLER) + "</head>")
//                    .replace(ACTION_RESULT, div(HtmlAttribute.ID + "ajax-placeholder", returned.toString()))
//                ;
//            } else {
//                render = render.replace(ACTION_RESULT, returned.toString());
//            }
//        }
//        return request
//            .makeResponse(ResponseStatusCode.OK)
//            .setBody(render)
//            .addHeader(ResponseHeader.CONTENT_TYPE, "text/html; charset=" + configuration.get(RESPONSE_ENCODING));
//    }
}
