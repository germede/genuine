package org.fluentness.task;

import org.fluentness.common.constants.AnsiColors;

public class Command implements AnsiColors {

    private final String[] parameters;
    private final String description;
    private final CommandExecutor executor;

    public Command(String[] parameters, String description, CommandExecutor executor) {
        this.parameters = parameters;
        this.description = description;
        this.executor = executor;
    }

    public String[] getParameters() {
        return parameters;
    }

    public String getDescription() {
        return description;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }
}