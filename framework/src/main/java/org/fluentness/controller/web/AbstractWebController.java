package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.HttpHandler;
import org.fluentness.service.server.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWebController implements Controller {

    public static Map<String, HttpHandler> getRoutingMap(List<AbstractWebController> webControllers) {
        Map<String, HttpHandler> result = new HashMap<>();
        webControllers.forEach(controller -> {
            Arrays.stream(controller.getActions()).forEach(action -> {
                result.put(action.getAnnotation(Action.class).path(), getHttpHandlerForAction(controller, action));
            });
        });
        return result;
    }

    private static HttpHandler getHttpHandlerForAction(AbstractWebController controller, Method action) {
        Class<?> returnType = action.getReturnType();
        if (returnType.equals(String.class)) {
            return (request, response) -> response.getWriter().write((String) action.invoke(controller, mapParameters(request, action)));
        } else if (returnType.equals(Integer.class) || returnType.equals(Integer.TYPE)) {
            return (request, response) -> response.setStatus((Integer) action.invoke(controller, mapParameters(request, action)));
        } else if (returnType.equals(Response.class)) {
            return (request, response) -> ((Response) action.invoke(controller, mapParameters(request, action))).handle(response);
        } else if (returnType.equals(WebView.class)) {
            return (request, response) -> response.getWriter().write(((WebView) action.invoke(controller, mapParameters(request, action))).render());
        }
        return (request, response) -> action.invoke(controller);
    }

    private static Object[] mapParameters(HttpServletRequest request, Method action) {
        Parameter[] actionParameters = action.getParameters();
        Object[] result = new Object[actionParameters.length];
        switch (request.getMethod()) {

            default: // GET
                for (int i = 0; i < actionParameters.length; i++) {
                    Parameter actionParameter = actionParameters[i];
                    if (actionParameter.getType().equals(HttpServletRequest.class)) {
                        result[i] = request;
                    } else {
                        result[i] = request.getParameter(actionParameter.getName());
                    }
                }
        }
        return result;
    }

    @Override
    public Method[] getActions() {
        return Arrays.stream(getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Action.class))
                .toArray(Method[]::new);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String path();

        HttpMethod method() default HttpMethod.GET;
    }

    @FunctionalInterface
    protected interface Response {
        void handle(HttpServletResponse response) throws IOException;
    }
}
