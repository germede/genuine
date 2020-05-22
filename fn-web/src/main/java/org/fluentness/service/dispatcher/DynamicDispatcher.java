package org.fluentness.service.dispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.server.RequestHeader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

import static org.fluentness.view.AbstractWebView.ACTION_RESULT;
import static org.fluentness.view.AbstractWebView.div;
import static org.fluentness.view.html.HtmlAttribute.ID;

public class DynamicDispatcher extends AbstractDispatcher {

    private final Configuration configuration;

    public DynamicDispatcher(Authentication[] authentications, Log log, Configuration configuration) {
        super(authentications, log);
        this.configuration = configuration;
    }

    @Override
    public String getUrlPattern() {
        return "/*";
    }

    @Override
    protected void dispatch(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {

        String key = request.getMethod() + " " + request.getRequestURI();
        Method action = routes.get(key);
        AbstractWebController controller = controllers.get(action);

        action.setAccessible(true);
        Object[] args = prepareArgs(action, request);
        Object returned = action.getParameterCount() > 0 ?
                action.invoke(controller, args) :
                action.invoke(controller);
        if (returned instanceof CharSequence) {
            handleWebView(request, response, controller, (CharSequence) returned);
        } else if (returned instanceof Integer) {
            response.setStatus((Integer) returned);
        }
    }

    private static Object[] prepareArgs(Method action, HttpServletRequest request) {
        Parameter[] parameters = action.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Class<?> type = parameter.getType();
            String name = parameter.getName();

            if (HttpServletRequest.class.isAssignableFrom(type)) {
                result[i] = request;
            } else if (type.equals(String.class)) {
                result[i] = request.getParameter(name);
            } else if (int.class.isAssignableFrom(type)) {
                result[i] = Integer.parseInt(request.getParameter(name));
            } else if (float.class.isAssignableFrom(type)) {
                result[i] = Float.parseFloat(request.getParameter(name));
            } else if (boolean.class.isAssignableFrom(type)) {
                result[i] = Boolean.parseBoolean(request.getParameter(name));
            } else if (Date.class.isAssignableFrom(type)) {
                result[i] = Date.parse(request.getParameter(name));
            }
        }
        return result;
    }

    private void handleWebView(HttpServletRequest request,
                               HttpServletResponse response,
                               AbstractWebController webController,
                               CharSequence returned) throws IOException {
        String render;
        if (request.getHeader(RequestHeader.X_REQUESTED_WITH) != null) {
            render = returned.toString();
        } else {
            render = webController.getWebView().toString();
            if (configuration.get(SINGLE_PAGE_MODE)) {
                render = render
                        .replace("</head>", configuration.get(AJAX_HANDLER) + "</head>")
                        .replace(ACTION_RESULT, div(ID + "ajax-placeholder", returned.toString()))
                ;
            } else {
                render = render.replace(ACTION_RESULT, returned.toString());
            }
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html");
        response.setCharacterEncoding(configuration.get(RESPONSE_ENCODING));
        response.getWriter().print(render);
    }
}
