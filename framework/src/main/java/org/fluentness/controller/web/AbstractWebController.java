package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWebController implements Controller<WebAction> {

    @Override
    public List<WebAction> getActions() {
        List<WebAction> result = new LinkedList<>();
        Arrays.stream(getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(Action.class))
            .forEach(method -> result.add(
                new WebAction(
                    method.getAnnotation(Action.class).path(),
                    method.getAnnotation(Action.class).method(),
                    method
                ))
            );
        return result;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String path();

        HttpMethod method() default HttpMethod.GET;
    }

}
