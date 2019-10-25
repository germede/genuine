package org.fluentness.flow.controller.console;

public class Task {

    private String description;
    private TaskExecutable executable;
    private String[] arguments;

    Task(String description, TaskExecutable executable) {
        this.description = description;
        this.executable = executable;
    }

    public String getDescription() {
        return description;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getCategory() {
        return getName().split(":")[0];
    }

    public void execute(String... arguments) {
        executable.execute(arguments);
    }

    public Task withArguments(String... arguments) {
        this.arguments = arguments;
        return this;
    }
}