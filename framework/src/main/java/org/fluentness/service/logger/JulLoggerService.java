package org.fluentness.service.logger;

import org.fluentness.service.configuration.ConfigurationService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.service.configuration.ConfigurationService.*;

public class JulLoggerService implements LoggerService {

    private java.util.logging.Logger logger;

    public JulLoggerService(ConfigurationService configuration) throws Exception {
        // retrieve log level
        Level logLevel = configuration.has(logger_level) ?
            configuration.get(logger_level).toJulLevel() :
            Level.ALL;

        // init jul logger
        logger = java.util.logging.Logger.getGlobal();
        logger.setUseParentHandlers(false);
        Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        logger.setLevel(logLevel);

        // console logging
        if (configuration.has(logger_console) && configuration.get(logger_console)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new JulFormatter());
            consoleHandler.setLevel(logLevel);
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (configuration.has(logger_file)) {
            new File(configuration.get(logger_file)).mkdirs();
            String logFilePath = configuration.get(logger_file) + "/" +
                new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) + ".txt";
            File file = new File(logFilePath);
            FileHandler fileHandler;
            if (file.exists()) {
                fileHandler = new FileHandler(logFilePath, true);
            } else {
                file.createNewFile();
                fileHandler = new FileHandler(logFilePath);
            }
            fileHandler.setFormatter(new JulFormatter());
            fileHandler.setLevel(logLevel);
            logger.addHandler(fileHandler);

        }
    }

    @Override
    public void debug(String message, Object... parameters) {
        log(LogLevel.DEBUG, message, parameters);
    }

    @Override
    public void info(String message, Object... parameters) {
        log(LogLevel.INFO, message, parameters);
    }

    @Override
    public void warning(String message, Object... parameters) {
        log(LogLevel.WARNING, message, parameters);
    }

    @Override
    public void error(String message, Object... parameters) {
        log(LogLevel.ERROR, message, parameters);
    }

    @Override
    public void error(Throwable throwable) {
        logger.log(LogLevel.ERROR.toJulLevel(), retrieveThrowableMessage(throwable));
    }

    @Override
    public void log(LogLevel logLevel, String message, Object... parameters) {
        logger.log(logLevel.toJulLevel(), format(message, parameters));
    }

    private String format(String message, Object... parameters) {
        if (parameters != null && parameters.length > 0) {
            return String.format(message, parameters);
        }
        return message;
    }

    private String retrieveThrowableMessage(Throwable throwable) {
        StringBuilder res = new StringBuilder();
        if (throwable.getMessage() == null) {
            res.append(throwable.getClass().getSimpleName()).append(":");
        } else {
            res.append(throwable.getClass().getSimpleName()).append(" ").append(throwable.getMessage()).append(":");
        }
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            res.append("\n    ").append(stackTraceElement.toString());
        }
        return throwable.getCause() != null ?
            res.toString() + "\nCaused by " + retrieveThrowableMessage(throwable.getCause()) :
            res.toString();
    }
}
