package org.fluentness.flow.controller;

import org.fluentness.base.service.Service;

public class Controller implements Service {

    private String baseRoute;
    private Action[] actions;

    Controller(String baseRoute, Action[] actions) {
        this.baseRoute = baseRoute;
        this.actions = actions;
    }

    Controller(Action[] actions) {
        this.baseRoute = "";
        this.actions = actions;
    }

    public String getBaseRoute() {
        return baseRoute;
    }

    public Action[] getActions() {
        return actions;
    }
}
