package org.fluentness.base.service.logger;

import org.fluentness.base.common.annotation.Inject;
import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.configuration.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.base.service.configuration.Configuration.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.service.configuration.Configuration.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.service.configuration.Configuration.LOG_LEVEL;

public class JulLogger implements Logger<Level> {

    private final java.util.logging.Logger logger;

    @Inject
    Configuration configuration;

    public JulLogger() throws DefinitionException {

        Level logLevel = configuration.has(LOG_LEVEL) ?
            FluentnessLogLevelToOwnLogLevel(configuration.get(LOG_LEVEL)) :
            Level.ALL;

        logger = java.util.logging.Logger.getLogger("");
        logger.setUseParentHandlers(false);
        if (logger.getHandlers().length > 0) {
            Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        }
        logger.setLevel(logLevel);

        // console logging
        if (configuration.has(ENABLE_LOG_TO_CONSOLE) &&
            configuration.get(ENABLE_LOG_TO_CONSOLE)) {

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new JulFormatter(this));
            consoleHandler.setLevel(logLevel);
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (configuration.has(ENABLE_LOG_TO_FILE) &&
            configuration.get(ENABLE_LOG_TO_FILE)) {

            try {
                new File(PrivateDirectories.LOG).mkdirs();
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
                fileHandler.setFormatter(new JulFormatter(this));
                fileHandler.setLevel(logLevel);
                logger.addHandler(fileHandler);
            } catch (IOException e) {
                throw new DefinitionException(e);
            }
        }

        info("I've been successfully defined");
    }


    @Override
    public void debug(String message, Object... parameters) {
        logger.finest(format(message, parameters));
    }

    @Override
    public void info(String message, Object... parameters) {
        logger.info(format(message, parameters));
    }

    @Override
    public void warn(String message, Object... parameters) {
        logger.warning(format(message, parameters));
    }

    @Override
    public void error(String message, Object... parameters) {
        logger.severe(format(message, parameters));
    }

    @Override
    public void error(Exception exception) {
        error(exceptionToMessage(exception));
    }

    @Override
    public FluentnessLogLevel ownLogLevelToFluentnessLogLevel(Level level) {
        return
            level.equals(Level.ALL) || level.equals(Level.FINEST) || level.equals(Level.FINER) || level.equals(Level.FINE) ? FluentnessLogLevel.DBUG :
                level.equals(Level.CONFIG) || level.equals(Level.INFO) ? FluentnessLogLevel.INFO :
                    level.equals(Level.WARNING) ? FluentnessLogLevel.WARN :
                        level.equals(Level.SEVERE) ? FluentnessLogLevel.ERRO :
                            FluentnessLogLevel.NONE;
    }

    @Override
    public Level FluentnessLogLevelToOwnLogLevel(FluentnessLogLevel level) {
        return
            level.equals(FluentnessLogLevel.DBUG) ? Level.ALL :
                level.equals(FluentnessLogLevel.INFO) ? Level.INFO :
                    level.equals(FluentnessLogLevel.WARN) ? Level.WARNING :
                        level.equals(FluentnessLogLevel.ERRO) ? Level.SEVERE :
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
