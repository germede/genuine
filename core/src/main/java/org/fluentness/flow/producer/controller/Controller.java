package org.fluentness.flow.producer.controller;

import org.fluentness.base.common.lambda.KeyValuePair;
import org.fluentness.flow.producer.Component;

public class Controller extends Component {

    private String baseRoute;
    private Action[] actions;

    Controller(String baseRoute, KeyValuePair<Action>[] actions) {
        this.baseRoute = baseRoute;
        this.actions = new Action[actions.length];
        for (int i = 0; i < actions.length; i++) {
            this.actions[i] = actions[i].getValue();
            this.actions[i].setName(actions[i].getKey());
        }
    }

    Controller(KeyValuePair<Action>[] actions) {
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
