package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.Request;
import org.fluentness.service.server.RequestMethod;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.server.RequestMethod.GET;

public abstract class AbstractWebController implements Controller {

    public static final Map<String, Method> pathMethodMap = new HashMap<>();
    public static final Map<String, String> methodPathMap = new HashMap<>();
    public static final ThreadLocal<Request> request = new ThreadLocal<>();

    private static final Map<Class, Object> viewInstances = new HashMap<>();
    protected final AbstractWebView view;

    public final AbstractWebView getView() {
        return view;
    }

    public AbstractWebController(Class<? extends AbstractWebView> viewClass) {
        if (!viewInstances.containsKey(viewClass)) {
            try {
                viewInstances.put(viewClass, viewClass.getConstructors()[0].newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        view = (AbstractWebView) viewInstances.get(viewClass);

        Constructor<?>[] constructors = getClass().getConstructors();
        Arrays.stream(getActions()).forEach(action -> {
            Action annotation = action.getAnnotation(Action.class);
            String path = constructors[0].isAnnotationPresent(BasePath.class) ?
                constructors[0].getAnnotation(BasePath.class).value() + annotation.path() :
                annotation.path();
            pathMethodMap.put(annotation.method() + " " + path, action);
            methodPathMap.put(action.getName(), path);
        });
    }

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {

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
