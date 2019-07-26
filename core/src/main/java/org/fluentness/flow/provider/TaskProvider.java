package org.fluentness.flow.provider;


import org.fluentness.Fluentness;
import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.component.task.TaskFactory;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class TaskProvider extends Provider<Task> implements TaskFactory {

    @Override
    public Class<Task> getProducedComponentType() {
        return Task.class;
    }


    public static Map<String, List<Task>> getAllTasks() {

        Map<String, List<Task>> categories = new TreeMap<>(

            Fluentness.getFlow().hasProvider(TaskProvider.class) ?

                Fluentness.getFlow().getProvider(TaskProvider.class).getComponents()


                )


            Fluentness
                .getFlow()
                .getProvider(TaskProvider.class)
                .getComponents()
                .stream()
                .collect(Collectors.groupingBy(task -> task.getName().split(":")[0]))
        );
        categories.forEach((s, tasks) -> tasks.sort(Comparator.comparing(Component::getName)));
        return categories;
    }

}
