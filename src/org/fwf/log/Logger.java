package org.fwf.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void log(Severity severity, String message) {
        switch (severity) {
            case DEBUG:
                logDebug(message);
                break;
            case INFO:
                logInfo(message);
                break;
            case WARNING:
                logWarning(message);
                break;
            case ERROR:
                logError(message);
                break;
        }
    }

    public static void log(Severity severity, String message, Exception exception) {
        message = message.concat(message + stackTraceToString(exception.getStackTrace()));
        log(severity, message);
    }

    private static String stackTraceToString(StackTraceElement[] stackTraceElements) {
        StringBuilder res = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            res.append(stackTraceElement.toString());
        }
        return res.toString();
    }

    private static void logDebug(String message) {
        System.out.println(getCurrentTime() + " [ERROR] " + message);
    }

    private static void logInfo(String message) {
        System.out.println(getCurrentTime() + " [INFO] " + message);
    }

    private static void logWarning(String message) {
        System.out.println(getCurrentTime() + " [WARNING] " + message);
    }

    private static void logError(String message) {
        System.out.println(getCurrentTime() + " [ERROR] " + message);
    }

    private static String getCurrentTime() {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
    }
}
