package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.Request;
import org.fluentness.service.server.RequestMethod;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.server.RequestMethod.GET;

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

        RequestMethod method() default GET;

        boolean authenticate() default true;

        boolean cache() default true;
    }

}
