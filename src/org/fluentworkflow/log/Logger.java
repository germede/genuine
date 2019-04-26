package org.fluentworkflow.log;

import org.fluentworkflow.cli.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void i(String messageWithPlaceholders, Object... parameters) {
        System.out.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_BLUE + " [INFO] " +
                Console.ANSI_WHITE + String.format(messageWithPlaceholders, parameters));
    }

    public static void d(String messageWithPlaceholders, Object... parameters) {
        System.out.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_GREEN + " [DEBUG] " +
                Console.ANSI_WHITE + String.format(messageWithPlaceholders, parameters));
    }

    public static void w(String messageWithPlaceholders, Object... parameters) {
        System.out.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_YELLOW + " [WARNING] " +
                Console.ANSI_WHITE + String.format(messageWithPlaceholders, parameters));
    }

    public static void e(String messageWithPlaceholders, Object... parameters) {
        System.err.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_RED + " [ERROR] " +
                Console.ANSI_WHITE + String.format(messageWithPlaceholders, parameters));
    }

    public static void e(Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = "Exception " + exception.getClass().getName();
        } else {
            message = exception.getMessage();
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        e(message);
    }

    public static void e(Exception exception, String message, Object... parameters) {
        if (message == null) {
            if (exception.getMessage() == null) {
                message = "Exception " + exception.getClass().getName();
            } else {
                message = exception.getMessage();
            }
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        e(message, parameters);
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
