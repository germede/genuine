package org.fluentness.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    public static final String ANSI_BLACK  = "\u001B[30m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";
    public static final String ANSI_WHITE  = "\u001B[37m";

    private Log() {

    }

    public static void info(Class calling, String message, Object... parameters) {
        System.out.println(ANSI_PURPLE + getCurrentTime() +
                ANSI_BLUE + " [INFO] " + calling.getSimpleName() + ": " +
                ANSI_WHITE + String.format(message, parameters));
    }

    public static void debug(Class calling, String message, Object... parameters) {
        System.out.println(ANSI_PURPLE + getCurrentTime() +
                ANSI_GREEN + " [DEBUG] " + calling.getSimpleName() + ": " +
                ANSI_WHITE + String.format(message, parameters));
    }

    public static void warning(Class calling, String message, Object... parameters) {
        System.out.println(ANSI_PURPLE + getCurrentTime() +
                ANSI_YELLOW + " [WARNING] " + calling.getSimpleName() + ": " +
                ANSI_WHITE + String.format(message, parameters));
    }

    public static void error(Class calling, String message, Object... parameters) {
        System.err.println(ANSI_PURPLE + getCurrentTime() +
                ANSI_RED + " [ERROR] " + calling.getSimpleName() + ": " +
                ANSI_WHITE + String.format(message, parameters));
    }

    public static void error(Class calling, Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = "Exception " + exception.getClass().getName();
        } else {
            message = exception.getMessage();
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        error(calling, message);
    }

    public static void error(Class calling, Exception exception, String message, Object... parameters) {
        if (message == null) {
            if (exception.getMessage() == null) {
                message = "Exception " + exception.getClass().getName();
            } else {
                message = exception.getMessage();
            }
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        error(calling, message, parameters);
    }

    private static String stackTraceToString(StackTraceElement[] stackTraceElements) {
        StringBuilder res = new StringBuilder();
        res.append("\n").append("Stacktrace:");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            res.append("\n    ").append(stackTraceElement.toString());
        }
        return res.toString();
    }

    private static String getCurrentTime() {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
    }
}
