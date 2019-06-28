package org.fluentness.base.logging;

import org.fluentness.Settings;
import org.fluentness.base.constants.PrivateDirectories;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.fluentness.base.constants.SettingKeys.*;

public enum  Log {

    INSTANCE;

    private Logger logger;

    public void configure() {
        String logLevel = toJavaLogLevel(Settings.INSTANCE.get(LOG_LEVEL));

        // create logger
        logger = java.util.logging.Logger.getLogger(Log.class.getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.parse(logLevel));

        // console logging
        if (Settings.INSTANCE.is(ENABLE_LOG_TO_CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            consoleHandler.setLevel(Level.parse(logLevel));
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (Settings.INSTANCE.is(ENABLE_LOG_TO_FILE)) {
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

    public void debug(String message, Object... parameters) {
        logger.fine(String.format(message, parameters));
    }

    public void info(String message, Object... parameters) {
        logger.info(String.format(message, parameters));
    }

    public void warning(String message, Object... parameters) {
        logger.warning(String.format(message, parameters));
    }

    public void error(String message, Object... parameters) {
        logger.severe(String.format(message, parameters));
    }

    public void error(Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = exception.getClass().getSimpleName() + ":";
        } else {
            message = exception.getClass().getSimpleName() + " " + exception.getMessage() + ":";
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        error(message);
    }

    public void fatal(String message, Object... parameters) {
        logger.severe(String.format(message, parameters));
        System.exit(1);
    }

    private String stackTraceToString(StackTraceElement[] stackTraceElements) {
        StringBuilder res = new StringBuilder();
        res.append("\n").append("Stacktrace:");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            res.append("\n    ").append(stackTraceElement.toString());
        }
        return res.toString();
    }

    String toNormalLogLevel(String javaLevel) {
        switch (javaLevel) {
            case "FINE":
                return "DEBUG";
            case "SEVERE":
                return "ERROR";
        }
        return javaLevel;
    }

    String toJavaLogLevel(String normalLevel) {
        switch (normalLevel) {
            case "DEBUG":
                return "FINE";
            case "ERROR":
                return "SEVERE";
        }
        return normalLevel;
    }
}
