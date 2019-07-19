package org.fluentness.base.logging;

import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.settings.Settings;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

import static org.fluentness.base.settings.BooleanKey.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.settings.BooleanKey.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.settings.StringKey.LOG_LEVEL;

public enum Log {
    instance;

    private Logger logger;

    public void initialize() {
        String logLevel = Settings.instance.get(LOG_LEVEL);

        // create logger
        logger = java.util.logging.Logger.getGlobal();
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.parse(logLevel));

        // console logging
        if (Settings.instance.get(ENABLE_LOG_TO_CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            consoleHandler.setLevel(Level.parse(logLevel));
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (Settings.instance.get(ENABLE_LOG_TO_FILE)) {
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

    public void debug(String message, Object... parameters) {
        logger.fine(format(message, parameters));
    }

    public void info(String message, Object... parameters) {
        logger.info(format(message, parameters));
    }

    public void warning(String message, Object... parameters) {
        logger.warning(format(message, parameters));
    }

    public void error(String message, Object... parameters) {
        logger.severe(format(message, parameters));
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
        error(format(message, parameters));
        System.exit(1);
    }

    public void fatal(Exception exception) {
        error(exception);
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
}
