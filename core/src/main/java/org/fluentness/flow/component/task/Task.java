package org.fluentness.flow.component.task;

import org.fluentness.flow.component.Component;

public class Task extends Component {

    private String description;
    private TaskExecutable executable;
    private String[] arguments;

    Task(String description, TaskExecutable executable, String[] arguments) {
        this.description = description;
        this.executable = executable;
        this.arguments = arguments;
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
}