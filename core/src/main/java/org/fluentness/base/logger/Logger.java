package org.fluentness.base.logger;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.PrivateDirectories;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.base.config.BooleanKey.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.config.BooleanKey.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.config.StringKey.LOG_LEVEL;

public class Logger {

    public Logger() {

    }

    private java.util.logging.Logger logger;

    public void initialize() {

        logger = java.util.logging.Logger.getGlobal();
        logger.setUseParentHandlers(false);

        String logLevel = "ALL";
        if (Fluentness.base.getConfig().has(LOG_LEVEL)) {
            logLevel = Fluentness.base.getConfig().get(LOG_LEVEL);
        }

        logger.setLevel(Level.parse(logLevel));

        // console logging
        if (Fluentness.base.getConfig().has(ENABLE_LOG_TO_CONSOLE) && Fluentness.base.getConfig().get(ENABLE_LOG_TO_CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            consoleHandler.setLevel(Level.parse(logLevel));
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (Fluentness.base.getConfig().has(ENABLE_LOG_TO_FILE) && Fluentness.base.getConfig().get(ENABLE_LOG_TO_FILE)) {
            new File(PrivateDirectories.LOG).mkdirs();
            try {
                String logFilePath = PrivateDirectories.LOG + "/" +
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) + ".txt";
                File file = new File(logFilePath);
                FileHandler fileHandler;
                if (file.exists()) {
                    fileHandler = new FileHandler(logFilePath, true);
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

    private String format(String message, Object... parameters) {
        if (parameters != null && parameters.length > 0) {
            return String.format(message, parameters);
        }
        return message;
    }

    public void fine(String message, Object... parameters) {
        logger.fine(format(message, parameters));
    }

    public void info(String message, Object... parameters) {
        logger.info(format(message, parameters));
    }

    public void warning(String message, Object... parameters) {
        logger.warning(format(message, parameters));
    }

    public void severe(String message, Object... parameters) {
        logger.severe(format(message, parameters));
    }

    public void severe(Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = exception.getClass().getSimpleName() + ":";
        } else {
            message = exception.getClass().getSimpleName() + " " + exception.getMessage() + ":";
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        severe(message);
    }

    private String stackTraceToString(StackTraceElement[] stackTraceElements) {
        StringBuilder res = new StringBuilder();
        res.append("\n").append("Stacktrace:");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            res.append("\n    ").append(stackTraceElement.toString());
        }
        return res.toString();
    }
}
