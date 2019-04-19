package org.fwf.log;

import org.fwf.cli.CliColor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    public static void d(String message) {
        System.out.println(
                CliColor.ANSI_PURPLE + getCurrentTime() +
                CliColor.ANSI_GREEN + " [DEBUG] " +
                CliColor.ANSI_WHITE + message);
    }

    public static void i(String message) {
        System.out.println(
                CliColor.ANSI_PURPLE + getCurrentTime() +
                CliColor.ANSI_BLUE + " [INFO] " +
                CliColor.ANSI_WHITE + message);
    }

    public static void w(String message) {
        System.out.println(
                CliColor.ANSI_PURPLE + getCurrentTime() +
                CliColor.ANSI_YELLOW + " [WARNING] " +
                CliColor.ANSI_WHITE + message);
    }

    public static void e(String message, Exception exception) {
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        e(message);
    }

    public static void e(String message) {
        System.out.println(
                CliColor.ANSI_PURPLE + getCurrentTime() +
                CliColor.ANSI_RED + " [ERROR] " +
                CliColor.ANSI_WHITE + message);
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
