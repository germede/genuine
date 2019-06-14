package org.fluentness.controller;

import org.fluentness.base.lambdas.KeyValuePair;

public class Controller {

    private KeyValuePair<Action>[] actions;

    public Controller(KeyValuePair<Action>[] actions) {
        this.actions = actions;
    }

    public KeyValuePair<Action>[] getActions() {
        return actions;
    }


}
