package org.fluentness.base.service.logger;

import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.configuration.ConfigurationService;

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

    public JulLogger(ConfigurationService configurationService) throws DefinitionException {
        Level logLevel = configurationService.contains(LOG_LEVEL) ?
                fluentnessLogLevelToOwnLogLevel(configurationService.get(LOG_LEVEL)) :
                Level.ALL;

        logger = java.util.logging.Logger.getLogger("");
        logger.setUseParentHandlers(false);
        if (logger.getHandlers().length > 0) {
            Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        }
        logger.setLevel(logLevel);

        // console logging
        if (configurationService.contains(LOG_TO_CONSOLE) &&
                configurationService.get(LOG_TO_CONSOLE)) {

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new JulFormatter(this));
            consoleHandler.setLevel(logLevel);
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (configurationService.contains(LOG_TO_FILE)) {

            try {
                new File(configurationService.get(LOG_TO_FILE)).mkdirs();
                String logFilePath = configurationService.get(LOG_TO_FILE) + "/" +
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
    public void log(LogLevel logLevel, String message, Object... parameters) {
        logger.log(fluentnessLogLevelToOwnLogLevel(logLevel), format(message, parameters));
    }

    @Override
    public void log(Exception exception) {
        logger.log(fluentnessLogLevelToOwnLogLevel(LogLevel.ERRO), exceptionToMessage(exception));
    }

    LogLevel ownLogLevelToFluentnessLogLevel(Level level) {
        return level.equals(Level.ALL) || level.equals(Level.FINEST) || level.equals(Level.FINER) || level.equals(Level.FINE) ? LogLevel.DBUG :
                level.equals(Level.CONFIG) || level.equals(Level.INFO) ? LogLevel.INFO :
                        level.equals(Level.WARNING) ? LogLevel.WARN :
                                level.equals(Level.SEVERE) ? LogLevel.ERRO :
                                        LogLevel.NONE;
    }

    Level fluentnessLogLevelToOwnLogLevel(LogLevel level) {
        return level.equals(LogLevel.DBUG) ? Level.ALL :
                level.equals(LogLevel.INFO) ? Level.INFO :
                        level.equals(LogLevel.WARN) ? Level.WARNING :
                                level.equals(LogLevel.ERRO) ? Level.SEVERE :
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
