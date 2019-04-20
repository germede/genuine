package org.fwf.log;

import org.fwf.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void i(String message) {
        System.out.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_BLUE + " [INFO] " +
                Console.ANSI_WHITE + message);
    }

    public static void d(String message) {
        System.out.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_GREEN + " [DEBUG] " +
                Console.ANSI_WHITE + message);
    }

    public static void w(String message) {
        System.out.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_YELLOW + " [WARNING] " +
                Console.ANSI_WHITE + message);
    }

    public static void e(String message) {
        System.out.println(Console.ANSI_PURPLE + getCurrentTime() +
                Console.ANSI_RED + " [ERROR] " +
                Console.ANSI_WHITE + message);
    }

    public static void e(String message, Exception exception) {
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        e(message);
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
