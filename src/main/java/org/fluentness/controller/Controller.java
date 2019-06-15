package org.fluentness.controller;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.onion.Component;

public class Controller implements Component {

    private Action[] actions;

    public Controller(KeyValuePair<Action>[] actions) {
        this.actions = new Action[actions.length];
        for (int i = 0; i < actions.length; i++) {
            this.actions[i] = actions[i].value();
            this.actions[i].setName(actions[i].key());
        }
    }

    public Action[] getActions() {
        return actions;
    }
}
