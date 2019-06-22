package org.fluentness.flow.task;

@FunctionalInterface
public interface Executable {
    void execute(String[] parameters);
}
