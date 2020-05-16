package org.fluentness.controller;

import org.fluentness.service.server.Request;
import org.fluentness.service.server.RequestMethod;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.server.RequestMethod.GET;

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

    @Override
    public final Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    public final W getWeb() {
        return web;
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
