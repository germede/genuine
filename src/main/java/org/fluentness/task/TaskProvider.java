package org.fluentness.task;

import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.common.Provider;
import org.fluentness.common.constants.AnsiColors;

public interface TaskProvider extends Provider<Task>, AnsiColors {

    default String[] parameters(String... parameters) {
        return parameters;
    }

    default Task steps(NamedValue<Step>... steps) {
        return new Task(new String[0], steps);
    }

    default Task steps(String[] parameters, NamedValue<Step>... steps) {
        return new Task(parameters, steps);
    }

    default Step step(String description, StepExecutor executor) {
        return new Step(description, executor);
    }


}
