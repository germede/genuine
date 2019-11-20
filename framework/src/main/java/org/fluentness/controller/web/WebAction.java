package org.fluentness.controller.web;

import org.fluentness.controller.Action;

import java.lang.reflect.Method;

public class WebAction implements Action {

    private String path;
    private String httpMethod;
    private boolean authentication;
    private boolean cache;
    private Method method;

    WebAction(String path, String httpMethod, boolean authentication, boolean cache, Method method) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.authentication = authentication;
        this.cache = cache;
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public boolean isCache() {
        return cache;
    }

    public Method getMethod() {
        return method;
    }
}
