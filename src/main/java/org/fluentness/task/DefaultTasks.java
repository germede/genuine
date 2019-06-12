package org.fluentness.task;

import org.fluentness.FnAtoz;
import org.fluentness.common.Utils;
import org.fluentness.common.logging.Log;
import org.fluentness.common.lambdas.NamedValue;
import org.fluentness.common.networking.HttpServer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultTasks implements TaskProvider {

    public Task help = commands(
        help -> command("Prints all available commands",
            (parameters) -> {
                System.out.println("\n" +
                    " _______                                \n" +
                    "(  /  //             _/_                \n" +
                    " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
                    "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

                System.out.println(ANSI_GREEN + "Available tasks:\n" + ANSI_RESET);

                // merge default and custom tasks
                Map<String, Task> tasks = new DefaultTasks().getAll();
                tasks.putAll(FnAtoz.getTaskProvider().getAll());
                tasks = new TreeMap<>(tasks);

                for (Map.Entry<String, Task> task : tasks.entrySet()) {

                    if (task.getValue().getCommands().length == 1) {
                        NamedValue<Command> command = task.getValue().getCommands()[0];
                        String parametersToPrint = command.value().getParameters().length > 0 ?
                            Arrays.toString(command.value().getParameters()) :
                            "";
                        System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET + "%s",
                            command.name() + " " + parametersToPrint,
                            task.getValue().getCommands()[0].value().getDescription()
                        ));
                        continue;
                    }
                    System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET,
                        task.getKey() + ":"
                    ));
                    for (NamedValue<Command> command : task.getValue().getCommands()) {
                        String parametersToPrint = command.value().getParameters().length > 0 ?
                            Arrays.toString(command.value().getParameters()) :
                            "";
                        System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
                            "    " + task.getKey() + ":" + command.name() + " " + parametersToPrint,
                            command.value().getDescription()
                        ));
                    }
                }

            }
        )
    );

    Task version = commands(
        version -> command("Prints current Fluentness version",
            parameters -> System.out.println("1.0-dev")
        )
    );

    Task clear = commands(
        cache -> command("Clears the cache files by deleting directory tmp/cache",
            parameters -> Utils.deleteDirectoryRecursively(new File("tmp/cache"))
        ),

        logs -> command("Clears the log files by deleting directory tmp/logs",
            parameters -> Utils.deleteDirectoryRecursively(new File("tmp/logs"))
        )
    );

    Task server = commands(

        start -> command("Starts embedded HTTP server",
            parameters -> HttpServer.start()
        ),

        stop -> command("Stops embedded HTTP server",
            parameters -> HttpServer.stop()
        )

    );

    Task generate = commands(
        // TODO: media queries
        style -> command(parameters("css_file"), "Generates style based on source CSS file",
            parameters -> {

                try {
                    Path path = Paths.get(parameters[0]);
                    String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

                    // remove comments
                    content = content.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");

                    // match rules
                    Pattern rulePattern = Pattern.compile("(.*?)\\{(.*?)\\}", Pattern.DOTALL | Pattern.MULTILINE);
                    Matcher matcher = rulePattern.matcher(content);
                    Map<String, String[]> parsed = new TreeMap<>();
                    while (matcher.find()) {
                        String selector = matcher.group(1).replaceAll("\\}","").replaceAll("\\s+", " ").trim();
                        String[] rules = matcher.group(2).split(";\n");
                        for (int i = 0; i < rules.length; i++) {
                            String[] cssRule = ("        " + rules[i].replaceAll("\\s+", "")).split(":");
                            if (cssRule.length == 1) {
                                cssRule = new String[]{cssRule[0], ""};
                            }
                            if (cssRule.length == 0) {
                                continue;
                            }
                            cssRule[0] = cssRule[0].replaceAll("float", "FLOAT");
                            rules[i] = cssRule[0].replaceAll("-","_") + "-> \"" + cssRule[1] + "\"";
                        }
                        parsed.put(selector, rules);
                    }

                    // print result
                    System.out.println("Style " + new File(parameters[0]).getName().replaceAll("\\..*", "") + " = css(");
                    for (Map.Entry<String, String[]> ruleset : parsed.entrySet()) {
                        System.out.println("    select(\"" + ruleset.getKey() + "\",");
                        System.out.println(String.join(",\n", ruleset.getValue()));
                        System.out.println("    ),\n");
                    }
                    System.out.println(");");
                } catch (IOException e) {
                    Log.error(e);
                }
            }
        ),

        run -> command("Starts embedded HTTP server",
            parameters -> HttpServer.start()
        )
    );

}
