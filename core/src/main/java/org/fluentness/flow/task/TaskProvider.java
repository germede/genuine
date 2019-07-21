package org.fluentness.flow.task;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.AnsiColors;
import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Provider;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public abstract class TaskProvider extends Provider<Task> implements AnsiColors {

    @Override
    public Class<Task> getProvidedComponentType() {
        return Task.class;
    }

    protected Task does(String description, TaskExecutor executable, String... args) {
        return new Task(description, executable, args);
    }

    private void deleteRecursively(File file) {
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
                Fluentness.base.getLogger().warning("Cannot delete %s", file.getPath());
            } else {
                Fluentness.base.getLogger().fine("Deleted file %s", file.getPath());
            }
        }
    }

    Map<String, List<Task>> getAllGroupedByCategory() {
        Map<String, List<Task>> categories = new TreeMap<>(
            getComponents().stream().collect(Collectors.groupingBy(task -> task.getName().split(":")[0]))
        );
        categories.forEach((s, tasks) -> tasks.sort(Comparator.comparing(Component::getName)));
        return categories;
    }

    // default tasks
    Task help = does("Prints all available commands",
        arguments -> {
            System.out.println("\n" +
                " _______                                \n" +
                "(  /  //             _/_                \n" +
                " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
                "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

            System.out.println(ANSI_GREEN + "Available tasks:\n" + ANSI_RESET);

            for (Map.Entry<String, List<Task>> category :
                Fluentness.flow.getProvider(TaskProvider.class).getAllGroupedByCategory().entrySet()
            ) {


                if (category.getValue().size() == 1) {
                    Task task = category.getValue().get(0);
                    String args = task.getArguments().length > 0 ? " " + Arrays.toString(task.getArguments()) : "";
                    System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET + "%s",
                        task.getName() + args, task.getDescription()));
                } else {
                    System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET, category.getKey()));
                    for (Task task : category.getValue()) {
                        String args = task.getArguments().length > 0 ? " " + Arrays.toString(task.getArguments()) : "";
                        System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
                            "    " + task.getName() + args,
                            task.getDescription()
                        ));
                    }
                }
            }
        }
    );

    Task print_onion = does("Prints the onion layer list sorted by priority",
        arguments -> Fluentness.flow.printOnionLayers()
    );

    Task print_version = does("Prints current Fluentness version",
        arguments -> System.out.println(Fluentness.class.getPackage().getImplementationVersion())
    );

    Task clear_view_cache = does("Clears the view cache by deleting directory " + PrivateDirectories.VIEW_CACHE,
        arguments -> deleteRecursively(new File(PrivateDirectories.VIEW_CACHE))
    );

    Task clear_style_cache = does("Clears the style cache by deleting directory " + PublicDirectories.STYLES,
        arguments -> deleteRecursively(new File(PublicDirectories.STYLES))
    );

    Task clear_logs = does("Clears the logger files by deleting directory " + PrivateDirectories.LOG,
        arguments -> deleteRecursively(new File(PrivateDirectories.LOG))
    );

    Task server_start = does("Starts embedded HTTP server",
        arguments -> Fluentness.base.getServer().start()
    );

    Task server_stop = does("Stops embedded HTTP server",
        arguments -> Fluentness.base.getServer().stop()
    );
}
