package org.fluentness.task;

@FunctionalInterface
public interface StepExecutor {
    void execute(String[] parameters);
}
