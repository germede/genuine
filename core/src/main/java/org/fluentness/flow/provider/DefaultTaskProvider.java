package org.fluentness.flow.provider;

import org.fluentness.Fluentness;
import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.common.constant.PublicDirectories;
import org.fluentness.base.service.logger.LoggerService;
import org.fluentness.base.service.server.ServerService;
import org.fluentness.flow.FlowConsumer;
import org.fluentness.flow.component.task.Task;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultTaskProvider extends TaskProvider implements FlowConsumer {

    private Map<String, List<Task>> getAllTasksGroupedByCategory() {
        // default tasks
        Map<String, List<Task>> categories = provideComponents().stream().collect(Collectors.groupingBy(Task::getCategory));

        // custom tasks
        if(canProviderBeConsumed(Task.class)) {
            categories.putAll(
                consumeProviderByComponent(Task.class).provideComponents().stream().collect(Collectors.groupingBy(Task::getCategory))
            );
        }
        return categories;
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
                consumeService(LoggerService.class).warning("Cannot delete %s", file.getPath());
            } else {
                consumeService(LoggerService.class).fine("Deleted file %s", file.getPath());
            }
        }
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
        arguments -> consumeService(ServerService.class).start(consumeProvider(ControllerProvider.class).getRouteHandlerMap())
    );

    Task server_stop = does("Stops embedded HTTP server",
        arguments -> consumeService(ServerService.class).stop()
    );
}
