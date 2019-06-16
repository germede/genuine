package org.fluentness.task;

import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.common.generics.Component;

import java.util.Arrays;

public class Task implements Component, Executable {

    private String description;
    private Step[] steps;
    private Executable executable;
    private String[] arguments;

    protected Task(String description, KeyValuePair<Step>... steps) {
        this.description = description;
        this.steps = Arrays.stream(steps).map(KeyValuePair::getValue).toArray(Step[]::new);
        this.steps = new Step[steps.length];
        for (int i = 0; i < steps.length; i++) {
            this.steps[i] = steps[i].getValue();
            this.steps[i].setName(steps[i].getKey());
        }
        this.executable = parameters -> Arrays.stream(steps).forEach(step -> step.getValue().execute(parameters));
        this.arguments = new String[0];
    }

    protected Task(String description, Executable executable) {
        this.description = description;
        this.steps = new Step[0];
        this.executable = executable;
        this.arguments = new String[0];
    }

    public String getDescription() {
        return description;
    }

    public Step[] getSteps() {
        return steps;
    }

    public String[] getArguments() {
        return arguments;
    }

    @Override
    public void execute(String[] parameters) {
        executable.execute(parameters);
    }

    public Task args(String... arguments) {
        this.arguments = arguments;
        return this;
    }
}