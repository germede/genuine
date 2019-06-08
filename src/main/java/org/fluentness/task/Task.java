package org.fluentness.task;

import org.fluentness.common.lambdas.NamedValue;

public class Task {

    private NamedValue<Command>[] commands;

    public Task(NamedValue<Command>[] commands) {
        this.commands = commands;
    }

    public NamedValue<Command>[] getCommands() {
        return commands;
    }


}