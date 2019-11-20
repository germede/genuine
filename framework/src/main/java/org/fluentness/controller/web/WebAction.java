package org.fluentness.controller.web;

import org.fluentness.controller.Action;
import org.fluentness.service.routing.HttpMethod;

import java.lang.reflect.Method;

public class WebAction implements Action {

    private String path;
    private HttpMethod httpMethod;
    private boolean authentication;
    private boolean cache;
    private Method method;

    WebAction(String path, HttpMethod httpMethod, boolean authentication, boolean cache, Method method) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.authentication = authentication;
        this.cache = cache;
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public HttpMethod getHttpMethod() {
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
