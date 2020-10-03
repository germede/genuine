package org.fluentness.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public enum JavaScriptCommand {
    CHANGE_INNER,
    APPEND_CHILD,
    TOGGLE_CLASS,
    ;

    private static final String COMMANDS_DELIMITER = "&&&";
    private static final String COMMAND_DELIMITER = "@@@";
    private static final String PARAMETER_DELIMITER = "###";

    private static final ThreadLocal<List<String>> commands = new ThreadLocal<>();

    public static void changeInner(String xpath, CharSequence inner) {
        addCommand(CHANGE_INNER, xpath, inner);
    }

    public static void appendChild(String xpath, CharSequence child) {
        addCommand(APPEND_CHILD, xpath, child);
    }

    public static void toggleClass(String xpath, String clazz) {
        addCommand(TOGGLE_CLASS, xpath, clazz);
    }

    private static void addCommand(JavaScriptCommand command, Object... parameters) {
        if (commands.get() == null) clear();
        commands.get().add(
            command.name() + COMMAND_DELIMITER + Arrays.stream(parameters).map(String::valueOf).collect(Collectors.joining(PARAMETER_DELIMITER))
        );
    }

    static void clear() {
        commands.remove();
        commands.set(new LinkedList<>());
    }

    public static String getCommands() {
        if (commands.get() == null) clear();
        String join = String.join(COMMANDS_DELIMITER, commands.get());
        clear();
        return join;
    }

}
