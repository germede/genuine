package org.fluentness.task;

import org.fluentness.Fluentness;
import org.fluentness.base.Utils;
import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.logging.Log;
import org.fluentness.base.networking.HttpServer;

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

public class FnTaskProvider extends TaskProducer {

    Task version = does("Prints current Fluentness version",
        arguments -> System.out.println("1.0-dev")
    );

    Task onion = does("Prints the Fluentness onion architecture",
        arguments -> {
            for (int i = 0; i < Fluentness.INSTANCE.onionArchitecture.size(); i++) {
                String component = Fluentness.INSTANCE.onionArchitecture.get(i).getSimpleName();
                if (i == 0) {
                    System.out.println("\n" + ANSI_GREEN + "               ↑ ");
                    System.out.println("LESS DEPENDANT | " + component + ANSI_RESET);
                    continue;
                }
                if (i == Fluentness.INSTANCE.onionArchitecture.size() - 1) {
                    System.out.println(ANSI_BLUE + "MORE DEPENDANT | " + component);
                    System.out.println("               ↓ " + ANSI_RESET);
                    continue;
                }
                System.out.println("               | " + component);
            }
        }
    );

    Task clear = does("Clears several temporal directories",
        view_cache -> step("Clears the view cache by deleting directory " + PrivateDirectories.VIEW_CACHE,
            arguments -> Utils.INSTANCE.deleteRecursively(new File(PrivateDirectories.VIEW_CACHE))
        ),

        style_cache -> step("Clears the style cache by deleting directory " + PublicDirectories.STYLE_CACHE,
            arguments -> Utils.INSTANCE.deleteRecursively(new File(PublicDirectories.STYLE_CACHE))
        ),

        logs -> step("Clears the log files by deleting directory " + PrivateDirectories.LOG,
            arguments -> Utils.INSTANCE.deleteRecursively(new File(PrivateDirectories.LOG))
        )
    );

    Task server = does("Starts embedded HTTP server",
        arguments -> HttpServer.INSTANCE.start()
    );

    Task stop = does("Stops embedded HTTP server",
        arguments -> HttpServer.INSTANCE.stop()
    );

    Task style = does("Generates style based on source CSS file",
        arguments -> {

            try {
                Path path = Paths.get(arguments[0]);
                String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

                // remove comments
                content = content.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");

                // match rules
                Pattern rulePattern = Pattern.compile("(.*?)\\{(.*?)}", Pattern.DOTALL | Pattern.MULTILINE);
                Matcher matcher = rulePattern.matcher(content);
                Map<String, String[]> parsed = new TreeMap<>();
                while (matcher.find()) {
                    String selector = matcher.group(1).replaceAll("}", "").replaceAll("\\s+", " ").trim();
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
                        rules[i] = cssRule[0].replaceAll("-", "_") + "-> \"" + cssRule[1] + "\"";
                    }
                    parsed.put(selector, rules);
                }

                // print result
                System.out.println("Style " + new File(arguments[0]).getName().replaceAll("\\..*", "") + " = css(");
                for (Map.Entry<String, String[]> ruleset : parsed.entrySet()) {
                    System.out.println("    select(\"" + ruleset.getKey() + "\",");
                    System.out.println(String.join(",\n", ruleset.getValue()));
                    System.out.println("    ),\n");
                }
                System.out.println(");");
            } catch (IOException e) {
                Log.INSTANCE.error(e);
            }
        }
    ).args("css_file_path");

    Task help = does("Prints all available commands",
        arguments -> {
            System.out.println("\n" +
                " _______                                \n" +
                "(  /  //             _/_                \n" +
                " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
                "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

            System.out.println(ANSI_GREEN + "Available tasks:\n" + ANSI_RESET);

            for (Map.Entry<String, Task> task : Fluentness.INSTANCE.tasks.getAll().entrySet()) {

                String[] declaredArguments = task.getValue().getArguments();

                String argumentsToPrint = declaredArguments.length > 0 ? Arrays.toString(declaredArguments) : "";
                System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET + "%s",
                    task.getKey() + " " + argumentsToPrint,
                    task.getValue().getDescription()
                ));

                if (task.getValue().getSteps().length > 0) {
                    Step[] steps = task.getValue().getSteps();
                    for (int i = 0; i < steps.length; i++) {
                        Step step = steps[i];
                        System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
                            "    " + (i + 1) + ". " + step.getName(),
                            step.getDescription()
                        ));
                    }
                }
            }

        }
    );
}
