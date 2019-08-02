package org.fluentness.flow.component.controller;

import org.fluentness.flow.component.Component;

public class Controller implements Component {

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
