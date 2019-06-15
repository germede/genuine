package org.fluentness.task;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.onion.Component;

import java.util.Arrays;

public class Task implements Component, Executable {

    private String description;
    private Step[] steps;
    private Executable executable;
    private String[] arguments;

    public Task(String description, KeyValuePair<Step>... steps) {
        this.description = description;
        this.steps = Arrays.stream(steps).map(KeyValuePair::value).toArray(Step[]::new);
        this.steps = new Step[steps.length];
        for (int i = 0; i < steps.length; i++) {
            this.steps[i] = steps[i].value();
            this.steps[i].setName(steps[i].key());
        }
        this.executable = parameters -> Arrays.stream(steps).forEach(step -> step.value().execute(parameters));
        this.arguments = new String[0];
    }

    public Task(String description, Executable executable) {
        this.description = description;
        this.steps = new Step[0];
        this.executable = executable;
        this.arguments = new String[0];
    }

    String getDescription() {
        return description;
    }

    Step[] getSteps() {
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