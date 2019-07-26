package org.fluentness.flow.producer.task;

import org.fluentness.Fluentness;
import org.fluentness.base.common.constant.AnsiColors;
import org.fluentness.flow.producer.Producer;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public abstract class TaskProducer extends Producer<Task> implements AnsiColors {

    @Override
    public Class<Task> getProducedComponentType() {
        return Task.class;
    }

    protected Task does(String description, TaskExecutor executable, String... args) {
        return new Task(description, executable, args);
    }

    protected void deleteRecursively(File file) {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteRecursively(entry);
                }
            }
        }
        if (file.exists()) {
            if (!file.delete()) {
                Fluentness.getBase().getLogger().warning("Cannot delete %s", file.getPath());
            } else {
                Fluentness.getBase().getLogger().fine("Deleted file %s", file.getPath());
            }
        }
    }

    public static Map<String, List<Task>> getAllTasks() {

        Map<String, List<Task>> categories = new TreeMap<>(

            Fluentness.getFlow().hasProducer(TaskProducer.class) ?

                Fluentness.getFlow().getProducer(TaskProducer.class).getComponents()


                )


            Fluentness
                .getFlow()
                .getProducer(TaskProducer.class)
                .getComponents()
                .stream()
                .collect(Collectors.groupingBy(task -> task.getName().split(":")[0]))
        );
        categories.forEach((s, tasks) -> tasks.sort(Comparator.comparing(Component::getName)));
        return categories;
    }
}
