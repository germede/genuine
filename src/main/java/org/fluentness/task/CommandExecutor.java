package org.fluentness.task;

@FunctionalInterface
public interface CommandExecutor {
    void execute(String[] parameters);
}
