package org.fluentness.logging;

import org.fluentness.common.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Logger {

    private static java.util.logging.Logger logger;
    private static final String LOG_FILE_PATH = "tmp/log/";

    static {
        String logLevel = Configuration.getString(Configuration.LOG_LEVEL);

        // create logger
        logger = java.util.logging.Logger.getLogger(Logger.class.getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.parse(logLevel));

        // console logging
        if (Configuration.getBoolean(Configuration.LOG_CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            consoleHandler.setLevel(Level.parse(logLevel));
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (Configuration.getBoolean(Configuration.LOG_FILE)) {
            try {
                String logFilePath = LOG_FILE_PATH +
                        new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis())) +
                        ".txt";
                File file = new File(logFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
                FileHandler fileHandler = new FileHandler(logFilePath);
                fileHandler.setFormatter(new FileFormatter());
                fileHandler.setLevel(Level.parse(logLevel));
                logger.addHandler(fileHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Logger() {

    }

    public static void fine(Class callingClass, String message, Object... parameters) {
        logger.fine(String.format(callingClass.getSimpleName() + ": " + message, parameters));
    }

    public static void info(Class callingClass, String message, Object... parameters) {
        logger.info(String.format(callingClass.getSimpleName() + ": " + message, parameters));
    }

    public static void warning(Class callingClass, String message, Object... parameters) {
        logger.warning(String.format(callingClass.getSimpleName() + ": " + message, parameters));
    }

    public static void severe(Class callingClass, String message, Object... parameters) {
        logger.severe(String.format(callingClass.getSimpleName() + ": " + message, parameters));
    }

    public static void severe(Class callingClass, Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = "Exception " + exception.getClass().getName();
        } else {
            message = exception.getMessage();
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        severe(callingClass, message);
    }

    public static void severe(Class callingClass, Exception exception, String message, Object... parameters) {
        if (message == null) {
            if (exception.getMessage() == null) {
                message = "Exception " + exception.getClass().getName();
            } else {
                message = exception.getMessage();
            }
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        severe(callingClass, message, parameters);
    }

    private static String stackTraceToString(StackTraceElement[] stackTraceElements) {
        StringBuilder res = new StringBuilder();
        res.append("\n").append("Stacktrace:");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            res.append("\n    ").append(stackTraceElement.toString());
        }
        return res.toString();
    }
}
