package org.fluentness.flow.component.controller;

import org.fluentness.base.common.constant.HttpMethod;

public class Action {

    private String name;
    private HttpMethod method;
    private String route;
    private Controlleri executor;

    Action(HttpMethod method, String route, Controlleri executor) {
        this.method = method;
        this.route = route;
        this.executor = executor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getRoute() {
        return route;
    }

    public Controlleri getExecutor() {
        return executor;
    }
}
