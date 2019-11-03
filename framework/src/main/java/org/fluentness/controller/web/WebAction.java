package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.router.HttpMethod;

import java.lang.reflect.Method;

public class WebAction implements Controller.Action {

    private String path;
    private HttpMethod httpMethod;
    private Method function;

    WebAction(String path, HttpMethod httpMethod, Method function) {
        this.path = path;
        this.httpMethod = httpMethod;
        this.function = function;
    }

    public String getPath() {
        return path;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    @Override
    public Method getMethod() {
        return function;
    }
}
