package org.fluentness.controller.web;

import org.fluentness.controller.Controller;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.controller.web.AbstractWebController.HttpMethod.GET;

public abstract class AbstractWebController<V extends AbstractWebView> implements Controller {

    private static final Map<String, Method> pathMethodMap = new HashMap<>();
    private static final Map<String, String> selectorPathMap = new HashMap<>();

    public static Map<String, Method> getPathMethodMap() {
        return pathMethodMap;
    }

    public static Map<String, String> getSelectorPathMap() {
        return selectorPathMap;
    }

    protected final V view;

    public AbstractWebController(V view) {
        this.view = view;
        view.setController(this);
        Arrays.stream(getActions()).forEach(action -> {
            Action annotation = action.getAnnotation(Action.class);
            pathMethodMap.put(annotation.method() + " " + annotation.path(), action);
            selectorPathMap.put(annotation.selector(), annotation.path());
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
