package org.fluentness.flow.provider;

import org.fluentness.Fluentness;
import org.fluentness.base.common.annotation.Inject;
import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.common.constant.PublicDirectories;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.Server;
import org.fluentness.flow.component.task.Task;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FluentnessTaskProvider extends TaskProvider {

    @Inject
    Logger logger;

    @Inject
    Server server;

    @Inject
    TaskProvider taskProvider;

    @Inject
    ControllerProvider controllerProvider;

    Task help = does("Prints all available commands",
        arguments -> {
            System.out.println("\n" +
                " _______                                \n" +
                "(  /  //             _/_                \n" +
                " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
                "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

            System.out.println(ANSI_GREEN + "Available tasks:\n" + ANSI_RESET);

            for (Map.Entry<String, List<Task>> category : getAllTasksGroupedByCategory().entrySet()) {

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
    Task version = does("Prints current Fluentness version",
        // todo fix
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
        arguments -> server.start(controllerProvider.getRouting())
    );

    Task server_stop = does("Stops embedded HTTP server",
        arguments -> server.stop()
    );

    public List<Task> getAllTasks() {
        List<Task> tasks = provideComponents();
        if(taskProvider != null) {
            tasks.addAll(taskProvider.provideComponents());
        }
        return tasks;
    }

    private Map<String, List<Task>> getAllTasksGroupedByCategory() {
        return getAllTasks().stream().collect(Collectors.groupingBy(Task::getCategory));
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
                logger.warn("Cannot delete %s", file.getPath());
            } else {
                logger.debug("Deleted file %s", file.getPath());
            }
        }
    }
}
