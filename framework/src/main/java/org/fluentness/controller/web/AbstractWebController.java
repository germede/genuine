package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.authenticator.BasicAuthenticator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebController<W extends AbstractWeb> implements Controller {


    private static final Map<String, WebAction> routes = new HashMap<>();
    private static final Map<WebActionReference, String> invertedRoutes = new HashMap<>();

    public static Map<String, WebAction> getRoutes() {
        return routes;
    }

    public static String getPath(WebActionReference action) {
        return invertedRoutes.get(action);
    }

    public static WebAction getAction(String path) {
        return routes.get(path);
    }

    protected final W web;

    protected AbstractWebController(Class<W> web) {
        try {
            this.web = web.getConstructor(AbstractWebController.class).newInstance(this);
            defineRoutes();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            this.web = null;
            e.printStackTrace();
        }
    }

    public final W getWeb() {
        return web;
    }

    protected void get(String path, WebActionReference webActionReference) {
        addRoute("GET", path, webActionReference);
    }

    protected void post(String path, WebActionReference webActionReference) {
        addRoute("POST", path, webActionReference);
    }

    protected void head(String path, WebActionReference webActionReference) {
        addRoute("HEAD", path, webActionReference);
    }

    protected void put(String path, WebActionReference webActionReference) {
        addRoute("PUT", path, webActionReference);
    }

    protected void patch(String path, WebActionReference webActionReference) {
        addRoute("PATCH", path, webActionReference);
    }

    protected void delete(String path, WebActionReference webActionReference) {
        addRoute("DELETE", path, webActionReference);
    }

    protected void trace(String path, WebActionReference webActionReference) {
        addRoute("TRACE", path, webActionReference);
    }

    protected void options(String path, WebActionReference webActionReference) {
        addRoute("OPTIONS", path, webActionReference);
    }

    protected void connect(String path, WebActionReference webActionReference) {
        addRoute("CONNECT", path, webActionReference);
    }

    protected Response redirect(WebActionReference webActionReference) {
        return response -> {
            response.setStatus(301);
            response.setHeader("Location", getPath(webActionReference));
        };
    }

    protected Response redirect(String url) {
        return response -> {
            response.setStatus(301);
            response.setHeader("Location", url);
        };
    }

    private void addRoute(String method, String path, WebActionReference webActionReference) {
        path = method + " " + path;
        routes.put(path, new WebAction(webActionReference, this));
        invertedRoutes.put(webActionReference, path);
    }

    protected abstract void defineRoutes();

    public static class Request extends HttpServletRequestWrapper {


        private String pathVariable;

        public Request(HttpServletRequest request) {
            super(request);
            request.getRequestURI();
        }
    }
    @FunctionalInterface
    public interface Response {

        void response(HttpServletResponse response);

    }
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Authentication {

        Class<? extends Authenticator>[] authenticators() default BasicAuthenticator.class;
    }
}
