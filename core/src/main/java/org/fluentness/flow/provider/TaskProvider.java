package org.fluentness.flow.provider;


import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.component.task.TaskFactory;

public abstract class TaskProvider extends Provider<Task> implements TaskFactory {

    @Override
    public int getDefinitionPriority() {
        return 2500;
    }

    @Override
    public Class<Task> getComponentClass() {
        return Task.class;
    }

}
