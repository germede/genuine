package org.fluentness.flow.producer.task;

@FunctionalInterface
public interface TaskExecutor {
    void execute(String[] arguments);
}
