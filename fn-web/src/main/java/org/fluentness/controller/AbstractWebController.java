package org.fluentness.controller;

import org.fluentness.service.server.Request;
import org.fluentness.service.server.RequestMethod;
import org.fluentness.view.AbstractWebView;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.server.RequestMethod.GET;

public abstract class AbstractWebController<W extends AbstractWebView> implements Controller {

    private final W webView;

    public static final Map<String, Method> pathMethodMap = new HashMap<>();
    public static final Map<String, String> methodPathMap = new HashMap<>();
    public static final ThreadLocal<Request> request = new ThreadLocal<>();

    public AbstractWebController(W webView) {
        this.webView = webView;
        Constructor<?>[] constructors = getClass().getConstructors();
        Arrays.stream(getActions()).forEach(action -> {
            Action annotation = action.getAnnotation(Action.class);
            String actionPath = annotation.path().equals("") ? "/" + action.getName() : annotation.path();
            String path = constructors[0].isAnnotationPresent(BasePath.class) ?
                constructors[0].getAnnotation(BasePath.class).value() + actionPath :
                actionPath;
            pathMethodMap.put(annotation.method() + " " + path, action);
            methodPathMap.put(this.getClass().getCanonicalName() + action.getName(), path);
        });
    }

    public final W getWebView() {
        return webView;
    }

    private Method[] getActions() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(Action.class))
            .toArray(Method[]::new);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {

        String path() default "";

        RequestMethod method() default GET;

        boolean authenticate() default true;

        boolean cache() default true;
    }

    @Target(ElementType.CONSTRUCTOR)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface BasePath {
        String value();
    }

}
