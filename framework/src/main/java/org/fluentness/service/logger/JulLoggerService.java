package org.fluentness.service.logger;

import org.fluentness.service.configuration.ConfigurationService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class JulLoggerService implements LoggerService {
    private java.util.logging.Logger logger;

    public JulLoggerService(ConfigurationService configurationService) throws Exception {
        Level logLevel = configurationService.has("log_level") ?
            fluentnessLogLevelToOwnLogLevel(LogLevel.valueOf(configurationService.get("log_level"))) :
            Level.ALL;

        logger = java.util.logging.Logger.getLogger("");
        logger.setUseParentHandlers(false);
        if (logger.getHandlers().length > 0) {
            Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        }
        logger.setLevel(logLevel);

        // console logging
        if (configurationService.is("log_to_console")) {

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new JulFormatter(this));
            consoleHandler.setLevel(logLevel);
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (configurationService.has("log_to_file")) {
            new File(configurationService.get("log_to_file")).mkdirs();
            String logFilePath = configurationService.get("log_to_file") + "/" +
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
        log(throwable);
    }

    private void log(LogLevel logLevel, String message, Object... parameters) {
        logger.log(fluentnessLogLevelToOwnLogLevel(logLevel), format(message, parameters));
    }

    private void log(Throwable throwable) {
        logger.log(fluentnessLogLevelToOwnLogLevel(LogLevel.ERROR), retrieveThrowableMessage(throwable));
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
