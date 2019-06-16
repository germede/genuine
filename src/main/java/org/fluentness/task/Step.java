package org.fluentness.task;

public class Step implements Executable {

    private String name;
    private final String description;
    private final Executable executable;

    protected Step(String description, Executable executable) {
        this.description = description;
        this.executable = executable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Executable getExecutable() {
        return executable;
    }

    @Override
    public void execute(String[] parameters) {
        executable.execute(parameters);
    }
}