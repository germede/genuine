package org.fluentness.controller.web;

import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebController<W extends WebViewProvider> implements Controller {

    private static final Map<String, WebAction> routes = new HashMap<>();

    public static Map<String, WebAction> getRoutes() {
        return routes;
    }

    protected AbstractWebController() {
        routing();
    }

    protected void get(String path, WebAction action) {
        routes.put("GET " + path, action);
    }

    protected void head(String path, WebAction action) {
        routes.put("HEAD " + path, action);
    }

    protected void post(String path, WebAction action) {
        routes.put("POST " + path, action);
    }

    protected void put(String path, WebAction action) {
        routes.put("PUT " + path, action);
    }

    protected void delete(String path, WebAction action) {
        routes.put("DELETE " + path, action);
    }

    protected void connect(String path, WebAction action) {
        routes.put("CONNECT " + path, action);
    }

    protected void options(String path, WebAction action) {
        routes.put("OPTIONS " + path, action);
    }

    protected void trace(String path, WebAction action) {
        routes.put("TRACE " + path, action);
    }

    protected void patch(String path, WebAction action) {
        routes.put("PATCH " + path, action);
    }


    protected abstract void routing();

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {

        String path();

        String method() default "GET";

        Class<? extends Authenticator>[] authenticators() default {};

        boolean cache() default true;
    }

}
