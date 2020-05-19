package org.fluentness.controller;

import org.fluentness.service.server.Request;
import org.fluentness.service.server.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebController<W extends AbstractWeb> implements Controller {

    private final W web;

    public static final Map<String, Method> pathMethodMap = new HashMap<>();
    public static final Map<String, String> methodPathMap = new HashMap<>();
    public static final ThreadLocal<Request> request = new ThreadLocal<>();

    public AbstractWebController(W web) {
        this.web = web;
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

    public final W getWeb() {
        return web;
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

        String method() default RequestMethod.GET;

        boolean authenticate() default true;

        boolean cache() default true;
    }

    @Target(ElementType.CONSTRUCTOR)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface BasePath {
        String value();
    }

}
