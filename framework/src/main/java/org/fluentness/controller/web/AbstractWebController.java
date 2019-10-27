package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.HttpMethod;
import org.fluentness.service.server.HttpServlet;
import org.fluentness.service.server.HttpStatusCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class AbstractWebController implements Controller {

    @Override
    public Method[] getActions() {
        return Arrays.stream(getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Action.class))
                .toArray(Method[]::new);
    }

    protected HttpServletResponse response(HttpStatusCode httpStatusCode, String body) {
        HttpServletResponse response = HttpServlet.response;
        response.setStatus(httpStatusCode.toInt());
        try {
            PrintWriter writer = response.getWriter();
            writer.print(body);
        } catch (IOException e) {
            // todo log
        }
        return response;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String path();
        HttpMethod method() default HttpMethod.GET;
    }
}
