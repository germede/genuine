package org.fluentness.flow.task;

import org.fluentness.Fluentness;
import org.fluentness.base.Utils;
import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.networking.HttpServer;
import org.fluentness.flow.Flow;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DefaultTasks extends TaskProvider {

    Task print_help = does("Prints all available commands",
        arguments -> {
            System.out.println("\n" +
                " _______                                \n" +
                "(  /  //             _/_                \n" +
                " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
                "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

            System.out.println(ANSI_GREEN + "Available tasks:\n" + ANSI_RESET);

            for (Map.Entry<String, List<Task>> category : Flow.instance.tasks.getAllGroupedByCategory().entrySet()) {


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

    Task print_onion = does("Prints the Fluentness genuine onion architecture",
        arguments -> {
            for (int i = 0; i < Flow.instance.onionArchitecture.size(); i++) {
                String component = Flow.instance.onionArchitecture.get(i).getSimpleName();
                if (i == 0) {
                    System.out.println("\n" + ANSI_GREEN + "               ↑ ");
                    System.out.println("LESS DEPENDANT | " + component + ANSI_RESET);
                    continue;
                }
                if (i == Flow.instance.onionArchitecture.size() - 1) {
                    System.out.println(ANSI_BLUE + "MORE DEPENDANT | " + component);
                    System.out.println("               ↓ " + ANSI_RESET);
                    continue;
                }
                System.out.println("               | " + component);
            }
            System.out.println();
        }
    );

    Task print_version = does("Prints current Fluentness version",
        arguments -> System.out.println(Fluentness.class.getPackage().getImplementationVersion())
    );

    Task clear_view_cache = does("Clears the view cache by deleting directory " + PrivateDirectories.VIEW_CACHE,
        arguments -> Utils.instance.deleteRecursively(new File(PrivateDirectories.VIEW_CACHE))
    );

    Task clear_style_cache = does("Clears the style cache by deleting directory " + PublicDirectories.STYLES,
        arguments -> Utils.instance.deleteRecursively(new File(PublicDirectories.STYLES))
    );

    Task clear_logs = does("Clears the log files by deleting directory " + PrivateDirectories.LOG,
        arguments -> Utils.instance.deleteRecursively(new File(PrivateDirectories.LOG))
    );

    Task server_start = does("Starts embedded HTTP server",
        arguments -> HttpServer.instance.start()
    );

    Task server_stop = does("Stops embedded HTTP server",
        arguments -> HttpServer.instance.stop()
    );

}
