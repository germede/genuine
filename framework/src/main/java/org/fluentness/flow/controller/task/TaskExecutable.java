package org.fluentness.flow.controller.task;

@FunctionalInterface
public interface TaskExecutable {
    void execute(String[] arguments);
}
