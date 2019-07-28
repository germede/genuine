package org.fluentness.flow.provider;


import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.component.task.TaskFactory;

@DefinitionPriority(2500)
public abstract class TaskProvider extends Provider<Task> implements TaskFactory {

    @Override
    public Class<Task> getComponentClass() {
        return Task.class;
    }

}
