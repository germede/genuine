package org.fluentness.base.service.logger;

import org.fluentness.base.exception.DefinitionException;
import org.fluentness.base.service.configuration.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class JulLogger implements Logger {

    private java.util.logging.Logger logger;

    public JulLogger(Configuration configuration) throws DefinitionException {
        Level logLevel = configuration.has("log_level") ?
                fluentnessLogLevelToOwnLogLevel(LogLevel.valueOf(configuration.get("log_level"))) :
                Level.ALL;

        logger = java.util.logging.Logger.getLogger("");
        logger.setUseParentHandlers(false);
        if (logger.getHandlers().length > 0) {
            Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        }
        logger.setLevel(logLevel);

        // console logging
        if (configuration.is("log_to_console")) {

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new JulFormatter(this));
            consoleHandler.setLevel(logLevel);
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (configuration.has("log_to_file")) {
            try {
                new File(configuration.get("log_to_file")).mkdirs();
                String logFilePath = configuration.get("log_to_file") + "/" +
                        new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) + ".txt";
                File file = new File(logFilePath);
                FileHandler fileHandler;
                if (file.exists()) {
                    fileHandler = new FileHandler(logFilePath, true);
                } else {
                    file.createNewFile();
                    fileHandler = new FileHandler(logFilePath);
                }
                fileHandler.setFormatter(new JulFormatter(this));
                fileHandler.setLevel(logLevel);
                logger.addHandler(fileHandler);
            } catch (IOException e) {
                throw new DefinitionException(e);
            }
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
    public void warn(String message, Object... parameters) {
        log(LogLevel.WARNING, message, parameters);
    }

    @Override
    public void error(String message, Object... parameters) {
        log(LogLevel.ERROR, message, parameters);
    }

    @Override
    public void error(Exception exception) {
        log(exception);
    }

    private void log(LogLevel logLevel, String message, Object... parameters) {
        logger.log(fluentnessLogLevelToOwnLogLevel(logLevel), format(message, parameters));
    }

    private void log(Exception exception) {
        logger.log(fluentnessLogLevelToOwnLogLevel(LogLevel.ERROR), exceptionToMessage(exception));
    }

    LogLevel ownLogLevelToFluentnessLogLevel(Level level) {
        return level.equals(Level.ALL) || level.equals(Level.FINEST) || level.equals(Level.FINER) || level.equals(Level.FINE) ? LogLevel.DEBUG :
                level.equals(Level.CONFIG) || level.equals(Level.INFO) ? LogLevel.INFO :
                        level.equals(Level.WARNING) ? LogLevel.WARNING :
                                level.equals(Level.SEVERE) ? LogLevel.ERROR :
                                        LogLevel.NONE;
    }

    private Level fluentnessLogLevelToOwnLogLevel(LogLevel level) {
        return level.equals(LogLevel.DEBUG) ? Level.ALL :
                level.equals(LogLevel.INFO) ? Level.INFO :
                        level.equals(LogLevel.WARNING) ? Level.WARNING :
                                level.equals(LogLevel.ERROR) ? Level.SEVERE :
                                        Level.OFF;
    }

    private String format(String message, Object... parameters) {
        if (parameters != null && parameters.length > 0) {
            return String.format(message, parameters);
        }
        return message;
    }

    private String exceptionToMessage(Exception exception) {
        StringBuilder res = new StringBuilder();
        if (exception.getMessage() == null) {
            res.append(exception.getClass().getSimpleName()).append(":");
        } else {
            res.append(exception.getClass().getSimpleName()).append(" ").append(exception.getMessage()).append(":");
        }
        res.append("\nStacktrace:");
        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
            res.append("\n    ").append(stackTraceElement.toString());
        }
        return res.toString();
    }
}
