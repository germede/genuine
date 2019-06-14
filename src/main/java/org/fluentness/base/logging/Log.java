package org.fluentness.base.logging;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.PrivateDirectories;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.base.constants.Settings.*;

public final class Log {

    private static java.util.logging.Logger logger;

    static {
        String logLevel;
        if (Fluentness.contains(LOG_LEVEL)) {
            logLevel = toJavaLogLevel(Fluentness.getString(LOG_LEVEL));
        } else {
            logLevel = "ALL";
        }

        // create logger
        logger = java.util.logging.Logger.getLogger(Log.class.getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.parse(logLevel));

        // console logging
        if (Fluentness.getBoolean(LOG_CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            consoleHandler.setLevel(Level.parse(logLevel));
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (Fluentness.getBoolean(LOG_FILE)) {
            new File(PrivateDirectories.LOG).mkdirs();
            try {
                String logFilePath = PrivateDirectories.LOG + "/" +
                        new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) + ".txt";
                File file = new File(logFilePath);
                FileHandler fileHandler;
                if (file.exists()) {
                    fileHandler = new FileHandler(logFilePath,true);
                } else {
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

    private Log() {

    }

    public static void debug(String message, Object... parameters) {
        logger.fine(String.format(message, parameters));
    }

    public static void info(String message, Object... parameters) {
        logger.info(String.format(message, parameters));
    }

    public static void warning(String message, Object... parameters) {
        logger.warning(String.format(message, parameters));
    }

    public static void error(String message, Object... parameters) {
        logger.severe(String.format(message, parameters));
    }

    public static void error(Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = exception.getClass().getSimpleName() + ":";
        } else {
            message = exception.getClass().getSimpleName() + " " + exception.getMessage() + ":";
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        error(message);
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
