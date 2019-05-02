package org.fluentness.logging;

import org.fluentness.common.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    private static Logger logger;
    private static final String LOG_FILE_PATH = "tmp/log/";

    static {
        String logLevel = Configuration.getString(Configuration.LOG_LEVEL);

        // create logger
        logger = Logger.getLogger(Log.class.getName());
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

    private Log() {

    }

    public static void fine(Class calling, String message, Object... parameters) {
        logger.fine(String.format(calling.getSimpleName() + ": " + message, parameters));
    }

    public static void info(Class calling, String message, Object... parameters) {
        logger.info(String.format(calling.getSimpleName() + ": " + message, parameters));
    }

    public static void warning(Class calling, String message, Object... parameters) {
        logger.warning(String.format(calling.getSimpleName() + ": " + message, parameters));
    }

    public static void severe(Class calling, String message, Object... parameters) {
        logger.severe(String.format(calling.getSimpleName() + ": " + message, parameters));
    }

    public static void severe(Class calling, Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = "Exception " + exception.getClass().getName();
        } else {
            message = exception.getMessage();
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        severe(calling, message);
    }

    public static void severe(Class calling, Exception exception, String message, Object... parameters) {
        if (message == null) {
            if (exception.getMessage() == null) {
                message = "Exception " + exception.getClass().getName();
            } else {
                message = exception.getMessage();
            }
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        severe(calling, message, parameters);
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
