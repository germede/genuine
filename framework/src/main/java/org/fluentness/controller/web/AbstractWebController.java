package org.fluentness.controller.web;

import org.fluentness.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWebController implements Controller {

    public final List<WebAction> getActions() {
        List<WebAction> result = new LinkedList<>();
        Arrays.stream(getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(Action.class))
            .forEach(method -> result.add(
                new WebAction(
                    method.getAnnotation(Action.class).path(),
                    method.getAnnotation(Action.class).method(),
                    method.getAnnotation(Action.class).authentication(),
                    method.getAnnotation(Action.class).cache(),
                    method
                ))
            );
        return result;
    }

    protected Response redirect(WebActionReference webActionReference) {
        return response -> {
            response.setStatus(301);
            response.setHeader("Location", webActionReference.getPath());
        };
    }

    protected Response redirect(String url) {
        return response -> {
            response.setStatus(301);
            response.setHeader("Location", url);
        };
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String path();

        String method() default "GET";

        boolean authentication() default false;

        boolean cache() default true;
    }

    public static class Request extends HttpServletRequestWrapper {
        public Request(HttpServletRequest request) {
            super(request);
        }
    }

    @FunctionalInterface
    public interface Response {
        void response(HttpServletResponse response);
    }

}
