package org.fluentness.flow.component.task;

@FunctionalInterface
public interface TaskExecutable {
    void execute(String[] arguments);
}
