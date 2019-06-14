package org.fluentness.task;

import org.fluentness.base.lambdas.KeyValuePair;

public class Task {

    private KeyValuePair<Command>[] commands;

    public Task(KeyValuePair<Command>[] commands) {
        this.commands = commands;
    }

    public KeyValuePair<Command>[] getCommands() {
        return commands;
    }


}