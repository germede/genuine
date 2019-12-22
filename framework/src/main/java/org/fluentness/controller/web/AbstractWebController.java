package org.fluentness.controller.web;

import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public abstract class AbstractWebController<W extends WebViewProvider> implements Controller {

    private static final HashMap<String, Method> routes = new HashMap<>();

    public static HashMap<String, Method> getRoutes() {
        return routes;
    }

    protected AbstractWebController() {
        Arrays.stream(this.getClass().getMethods())
            .filter(method -> method.isAnnotationPresent(AbstractWebController.Action.class))
            .forEach(method ->
                routes.put(
                    method.getAnnotation(AbstractWebController.Action.class).method() +
                        " " +
                        method.getAnnotation(AbstractWebController.Action.class).path(),
                    method
                )
            );
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {
        String path();

        String method() default "GET";

        Class<? extends Authenticator>[] authenticators() default {};

        boolean cache() default true;
    }

}
