package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.router.HttpMethod;

import java.lang.reflect.Method;

public class WebAction implements Controller.Action {

    private String path;
    private HttpMethod httpMethod;
    private boolean authentication;
    private Method method;

    WebAction(String path, HttpMethod httpMethod, boolean authentication, Method method) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.authentication = authentication;
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

    @Override
    public Method getMethod() {
        return method;
    }
}
