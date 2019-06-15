package org.fluentness.task;

import org.fluentness.base.constants.AnsiColors;
import org.fluentness.base.generics.Producer;
import org.fluentness.base.lambdas.KeyValuePair;

public abstract class TaskProducer implements Producer<Task>, AnsiColors {

    @Override
    public Class<Task> getProducedComponentType() {
        return Task.class;
    }

    protected String[] parameters(String... parameters) {
        return parameters;
    }

    protected Task commands(KeyValuePair<Command>... commands) {
        return new Task(commands);
    }

    protected Command command(String[] parameters, String description, CommandExecutor executor) {
        return new Command(parameters, description, executor);
    }

    protected Command command(String description, CommandExecutor executor) {
        return new Command(new String[0], description, executor);
    }

}
