package org.fluentness.task;

import org.fluentness.Fluentness;
import org.fluentness.common.Utils;
import org.fluentness.common.constants.PrivateDirectories;
import org.fluentness.common.constants.PublicDirectories;
import org.fluentness.common.logging.Log;
import org.fluentness.common.networking.HttpServer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultTasks extends TaskProvider {

    Task help = does("Shows all available commands",
        arguments -> {
            Fluentness.INSTANCE.printHelp();
        }
    );

    Task print_version = does("Prints current Fluentness version",
        arguments -> System.out.println("1.0-dev")
    );

    Task print_onion = does("Prints the Fluentness onion architecture",
        arguments -> {
            Fluentness.INSTANCE.printOnionArchitecture();
        }
    );

    Task clear = does("Clears several temporal directories",
        view_cache -> step("Clears the view cache by deleting directory " + PrivateDirectories.VIEW_CACHE,
            arguments -> Utils.INSTANCE.deleteRecursively(new File(PrivateDirectories.VIEW_CACHE))
        ),

        style_cache -> step("Clears the style cache by deleting directory " + PublicDirectories.STYLES,
            arguments -> Utils.INSTANCE.deleteRecursively(new File(PublicDirectories.STYLES))
        ),

        logs -> step("Clears the log files by deleting directory " + PrivateDirectories.LOG,
            arguments -> Utils.INSTANCE.deleteRecursively(new File(PrivateDirectories.LOG))
        )
    );

    Task server_start = does("Starts embedded HTTP server",
        arguments -> HttpServer.INSTANCE.start()
    );

    Task server_stop = does("Stops embedded HTTP server",
        arguments -> HttpServer.INSTANCE.stop()
    );

    Task generate_style = does("Generates style based on source CSS file",
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
    ).args("css");

}
