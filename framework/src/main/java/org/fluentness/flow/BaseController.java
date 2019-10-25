package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.common.annotation.Inject;
import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.common.constant.PublicDirectories;
import org.fluentness.flow.console.ConsoleAction;
import org.fluentness.flow.console.Task;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.fluentness.flow.console.AnsiColor.*;

public class BaseController implements Controller {

    @ConsoleAction(description = "Prints all available commands", arguments = {})
    public void help() {
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
        arguments -> serverService.start(controllerProvider.getRoutes())
    );

    Task server_stop = does("Stops embedded HTTP server",
        arguments -> serverService.stop()
    );

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
