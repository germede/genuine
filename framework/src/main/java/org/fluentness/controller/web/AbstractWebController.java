package org.fluentness.controller.web;

import org.fluentness.controller.Controller;

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

    public String getActionPath(Method action) {
        return action.isAnnotationPresent(Action.class) ?
            action.getAnnotation(Action.class).path() :
            "";
    }

    public String getActionMethod(Method action) {
        return action.isAnnotationPresent(Action.class) ?
            action.getAnnotation(Action.class).method() :
            "";
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String path();

        String method() default "GET";
    }

}
