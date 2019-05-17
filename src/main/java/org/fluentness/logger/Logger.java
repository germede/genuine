package org.fluentness.logger;

import org.fluentness.configuration.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.configuration.Configuration.LOG_LEVEL;

public final class Logger {

    private static java.util.logging.Logger logger;
    private static final String LOG_FILE_PATH = "tmp/log/";

    static {
        String logLevel;
        if (Configuration.contains(LOG_LEVEL)) {
            logLevel = toJavaLogLevel(Configuration.getString(LOG_LEVEL));
        } else {
            logLevel = "ALL";
        }

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
                        new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) + ".txt";
                File file = new File(logFilePath);
                FileHandler fileHandler;
                if (file.exists()) {
                    fileHandler = new FileHandler(logFilePath,true);
                } else {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                    fileHandler = new FileHandler(logFilePath);
                }
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

    public static void debug(Class callingClass, String message, Object... parameters) {
        logger.fine(String.format(callingClass.getSimpleName() + " - " + message, parameters));
    }

    public static void info(Class callingClass, String message, Object... parameters) {
        logger.info(String.format(callingClass.getSimpleName() + " - " + message, parameters));
    }

    public static void warning(Class callingClass, String message, Object... parameters) {
        logger.warning(String.format(callingClass.getSimpleName() + " - " + message, parameters));
    }

    public static void error(Class callingClass, String message, Object... parameters) {
        logger.severe(String.format(callingClass.getSimpleName() + " - " + message, parameters));
    }

    public static void error(Class callingClass, Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = exception.getClass().getSimpleName() + ":";
        } else {
            message = exception.getClass().getSimpleName() + " " + exception.getMessage() + ":";
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        error(callingClass, message);
    }

    private static String stackTraceToString(StackTraceElement[] stackTraceElements) {
        StringBuilder res = new StringBuilder();
        res.append("\n").append("Stacktrace:");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            res.append("\n    ").append(stackTraceElement.toString());
        }
        return res.toString();
    }

    static String toNormalLogLevel(String javaLevel) {
        switch (javaLevel) {
            case "FINE": return "DEBUG";
            case "SEVERE": return "ERROR";
        }
        return javaLevel;
    }

    static String toJavaLogLevel(String normalLevel) {
        switch (normalLevel) {
            case "DEBUG": return "FINE";
            case "ERROR": return "SEVERE";
        }
        return normalLevel;
    }
}
