package org.fluentness.task;

import org.fluentness.common.constants.AnsiColors;

public class Step implements AnsiColors {

    private final String description;
    private final StepExecutor executor;

    public Step(String description, StepExecutor executor) {
        this.description = description;
        this.executor = executor;
    }

    public String getDescription() {
        return description;
    }

    public StepExecutor getExecutor() {
        return executor;
    }
}