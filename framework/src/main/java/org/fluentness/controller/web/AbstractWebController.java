package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.authenticator.BasicAuthenticator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebController<W extends AbstractWeb> implements Controller {

    private static final Map<String, WebAction> globalRoutes = new HashMap<>();
    private static final Map<Method, String> invertRoutes = new HashMap<>();

    public static Map<String, WebAction> getGlobalRoutes() {
        return globalRoutes;
    }

    public static String getPath(WebAction action) {
        return invertRoutes.get(action.getMethod());
    }

    protected W web;

    protected AbstractWebController(Class<W> webClass) {
        try {
            this.web = webClass.getConstructor(this.getClass()).newInstance(this);
            this.defineRoutes();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public final W getWeb() {
        return web;
    }

    public static void get(String path, WebAction webAction) {
        addRoute("GET", path, webAction);
    }

    public static void post(String path, WebAction webAction) {
        addRoute("POST", path, webAction);
    }

    public static void head(String path, WebAction webAction) {
        addRoute("HEAD", path, webAction);
    }

    public static void put(String path, WebAction webAction) {
        addRoute("PUT", path, webAction);
    }

    public static void patch(String path, WebAction webAction) {
        addRoute("PATCH", path, webAction);
    }

    public static void delete(String path, WebAction webAction) {
        addRoute("DELETE", path, webAction);
    }

    public static void trace(String path, WebAction webAction) {
        addRoute("TRACE", path, webAction);
    }

    public static void options(String path, WebAction webAction) {
        addRoute("OPTIONS", path, webAction);
    }

    public static void connect(String path, WebAction webAction) {
        addRoute("CONNECT", path, webAction);
    }

    private static void addRoute(String method, String path, WebAction webAction) {
        if (webAction.getMethod() == null) {
            System.err.println("Web action referenced method for path " + path + " must be public");
            System.exit(1);
        }
        path = method + " " + path;
        globalRoutes.put(path, webAction);
        invertRoutes.put(webAction.getMethod(), path);
    }

    public abstract void defineRoutes();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Authentication {

        Class<? extends Authenticator>[] authenticators() default BasicAuthenticator.class;
    }
}
