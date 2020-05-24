package org.fluentness.controller.event;

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

    private static ThreadLocal<List<String>> commandsToSend = new ThreadLocal<>();

    public static void changeInner(int id, CharSequence inner) {
        addCommand(CHANGE_INNER, id, inner);
    }

    public static void appendChild(int id, HtmlComponent child) {
        addCommand(APPEND_CHILD, id, child);
    }

    private static boolean addCommand(JavaScriptCommand command, Object... parameters) {
        return commandsToSend.get().add(
            command.name() + COMMAND_DELIMITER + Arrays.stream(parameters).map(String::valueOf).collect(Collectors.joining(PARAMETER_DELIMITER))
        );
    }

    static void clear() {
        commandsToSend.remove();
        commandsToSend.set(new LinkedList<>());
    }

    static String getCommands() {
        return commandsToSend.get().stream().collect(Collectors.joining(COMMANDS_DELIMITER));
    }

}
