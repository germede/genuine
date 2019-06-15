package org.fluentness.task;

import org.fluentness.base.constants.AnsiColors;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.onion.Producer;

public abstract class TaskProducer implements Producer<Task>, AnsiColors {

    @Override
    public Class<Task> getProducedComponentType() {
        return Task.class;
    }

    protected Task does(String description, Executable executable) {
        return new Task(description, executable);
    }

    protected Task does(String description, KeyValuePair<Step>... steps) {
        return new Task(description, steps);
    }

    protected Step step(Executable executor) {
        return new Step("", executor);
    }

    protected Step step(String description, Executable executor) {
        return new Step(description, executor);
    }

}
