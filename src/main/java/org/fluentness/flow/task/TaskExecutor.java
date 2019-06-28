package org.fluentness.flow.task;

@FunctionalInterface
public interface TaskExecutor {
    void execute(String[] parameters);
}
