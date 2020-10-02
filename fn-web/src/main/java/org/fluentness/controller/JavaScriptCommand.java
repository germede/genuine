package org.fluentness.controller;

import org.fluentness.view.component.HtmlComponent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public enum JavaScriptCommand {
    CHANGE_INNER,
    APPEND_CHILD,
    ;

    private static final String COMMANDS_DELIMITER = "&&&";
    private static final String COMMAND_DELIMITER = "@@@";
    private static final String PARAMETER_DELIMITER = "###";

    private static final ThreadLocal<List<String>> commands = new ThreadLocal<>();

    public static void changeInner(String xpath, CharSequence inner) {
        addCommand(CHANGE_INNER, xpath, inner);
    }

    public static void appendChild(String xpath, HtmlComponent child) {
        addCommand(APPEND_CHILD, xpath, child);
    }

    private static void addCommand(JavaScriptCommand command, Object... parameters) {
        commands.get().add(
            command.name() + COMMAND_DELIMITER + Arrays.stream(parameters).map(String::valueOf).collect(Collectors.joining(PARAMETER_DELIMITER))
        );
    }

    static void clear() {
        commands.remove();
        commands.set(new LinkedList<>());
    }

    static String getCommands() {
        return String.join(COMMANDS_DELIMITER, commands.get());
    }

}
