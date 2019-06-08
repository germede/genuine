package org.fluentness.common.logging;

import org.fluentness.FnConf;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.common.constants.Settings.*;

public final class Logger {

    private static java.util.logging.Logger logger;
    private static final String LOG_FILE_PATH = "tmp/log/";

    static {
        String logLevel;
        if (FnConf.contains(LOG_LEVEL)) {
            logLevel = toJavaLogLevel(FnConf.getString(LOG_LEVEL));
        } else {
            logLevel = "ALL";
        }

        // create logger
        logger = java.util.logging.Logger.getLogger(Logger.class.getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.parse(logLevel));

        // console logging
        if (FnConf.getBoolean(LOG_CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            consoleHandler.setLevel(Level.parse(logLevel));
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (FnConf.getBoolean(LOG_FILE)) {
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
