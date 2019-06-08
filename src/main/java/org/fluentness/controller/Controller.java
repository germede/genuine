package org.fluentness.controller;

import org.fluentness.common.lambdas.NamedValue;

public class Controller {

    private NamedValue<Action>[] actions;

    public Controller(NamedValue<Action>[] actions) {
        this.actions = actions;
    }

    public NamedValue<Action>[] getActions() {
        return actions;
    }


}
