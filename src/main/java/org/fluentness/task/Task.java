package org.fluentness.task;

import org.fluentness.common.namedValues.NamedValue;

import java.util.Arrays;

public class Task {

    private String[] parameters;
    private NamedValue<Step>[] steps;

    public Task(String[] parameters, NamedValue<Step>[] steps) {
        this.parameters = parameters;
        this.steps = steps;
    }

    public String[] getParameters() {
        return parameters;
    }

    public NamedValue<Step>[] getSteps() {
        return steps;
    }

    public String printParameters() {
        if (parameters == null || parameters.length == 0) {
            return "";
        }
        return Arrays.toString(parameters) + " ";
    }
}