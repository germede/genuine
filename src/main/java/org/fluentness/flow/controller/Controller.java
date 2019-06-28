package org.fluentness.flow.controller;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.generics.Component;

public class Controller implements Component {

    private String baseRoute;
    private Action[] actions;

    protected Controller(String baseRoute, KeyValuePair<Action>[] actions) {
        this.baseRoute = baseRoute;
        this.actions = new Action[actions.length];
        for (int i = 0; i < actions.length; i++) {
            this.actions[i] = actions[i].getValue();
            this.actions[i].setName(actions[i].getKey());
        }
    }

    protected Controller(KeyValuePair<Action>[] actions) {
        this.baseRoute = "";
        this.actions = new Action[actions.length];
        for (int i = 0; i < actions.length; i++) {
            this.actions[i] = actions[i].getValue();
            this.actions[i].setName(actions[i].getKey());
        }
    }

    public String getBaseRoute() {
        return baseRoute;
    }

    public Action[] getActions() {
        return actions;
    }
}
