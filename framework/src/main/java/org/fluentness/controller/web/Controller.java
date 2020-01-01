package org.fluentness.controller.web;

import java.util.HashMap;
import java.util.Map;

public abstract class Controller<W extends View> implements org.fluentness.controller.Controller {

    protected final W web;
    private final Map<String, WebAction> routes = new HashMap<>();

    protected Controller() {
        // convention: WebController controls Web
        try {
            this.web = (W) Class.forName(getClass().getCanonicalName().replace("Controller", "")).newInstance();
            this.web.setController(this);
            routing();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            this.web = null;
            System.exit(1);
        }
    }

    public final W getWeb() {
        return web;
    }

    public final Map<String, WebAction> getRoutes() {
        return routes;
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


}
