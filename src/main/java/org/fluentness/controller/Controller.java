package org.fluentness.controller;

import org.fluentness.common.namedValues.NamedValue;

public class Controller {

    private NamedValue<Action>[] actions;

    public Controller(NamedValue<Action>[] actions) {
        this.actions = actions;
    }

    public NamedValue<Action>[] getActions() {
        return actions;
    }


}
