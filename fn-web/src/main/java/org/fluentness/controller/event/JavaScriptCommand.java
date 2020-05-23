package org.fluentness.controller.event;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public enum JavaScriptCommand {
    CHANGE_INNER;

    private static ThreadLocal<List<String>> commandsToSend = new ThreadLocal<>();

    public static void clear() {
        commandsToSend.remove();
        commandsToSend.set(new LinkedList<>());
    }

    public static void addCommand(JavaScriptCommand command, Object... parameters) {
        commandsToSend.get().add(command.name() + ":" + Arrays.stream(parameters).map(String::valueOf).collect(Collectors.joining(",")));
    }

    static String getCommands() {
        return commandsToSend.get().stream().collect(Collectors.joining("|"));
    }

}
