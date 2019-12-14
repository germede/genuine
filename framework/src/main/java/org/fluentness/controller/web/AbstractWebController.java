package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.authenticator.Authenticator;
import org.fluentness.authenticator.BasicAuthenticator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public abstract class AbstractWebController<W extends WebViewProvider> implements Controller {

    private static final HashMap<String, Method> routes = new HashMap<>();

    public static HashMap<String, Method> getRoutes() {
        return routes;
    }

    protected final W web;

    protected AbstractWebController(Class<W> webClass) {
        W web = null;
        try {
            web = webClass.getConstructor(this.getClass()).newInstance(this);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        this.web = web;

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

    public final W getWeb() {
        return web;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Authentication {
        Class<? extends Authenticator>[] authenticators() default BasicAuthenticator.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {
        String path();

        String method() default "GET";

        boolean cache() default true;
    }

}
