package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.Request;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.controller.web.AbstractWebController.HttpMethod.GET;

public abstract class AbstractWebController<V extends AbstractWebView> implements Controller {

    public static final Map<String, Method> pathMethodMap = new HashMap<>();
    public static final Map<String, String> methodPathMap = new HashMap<>();
    public static final ThreadLocal<Request> request = new ThreadLocal<>();

    protected final V view;

    public AbstractWebController(V view) {
        this.view = view;
        view.setController(this);
        Arrays.stream(getActions()).forEach(action -> {
            Action annotation = action.getAnnotation(Action.class);
            pathMethodMap.put(annotation.method() + " " + annotation.path(), action);
            methodPathMap.put(action.getName(), annotation.path());
        });
    }

    public final V view() {
        return view;
    }

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {

        String path();

        String selector() default "";

        HttpMethod method() default GET;

        boolean authenticate() default false;

        boolean cache() default true;
    }


    protected enum HttpMethod {
        GET,
        HEAD,
        POST,
        PUT,
        DELETE,
        CONNECT,
        OPTIONS,
        TRACE,
        PATCH,
    }
}
