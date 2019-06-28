package org.fluentness.flow.task;

import org.fluentness.base.constants.AnsiColors;
import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Provider;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public abstract class TaskProvider extends Provider<Task> implements AnsiColors {

    @Override
    public Class<Task> getProducedComponentType() {
        return Task.class;
    }

    protected Task does(String description, TaskExecutor executable, String... args) {
        return new Task(description, executable, args);
    }

    Map<String, List<Task>> getAllGroupedByCategory() {
        Map<String, List<Task>> categories = new TreeMap<>(
            getAll().stream().collect(Collectors.groupingBy(task -> task.getName().split(":")[0]))
        );
        categories.forEach((s, tasks) -> tasks.sort(Comparator.comparing(Component::getName)));
        return categories;
    }
}
