package org.fluentness.base.service.logger;

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

import static org.fluentness.base.service.configuration.Key.Boolean.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.service.configuration.Key.Boolean.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.service.configuration.Key.LogLevel.LOG_LEVEL;

public class JulLogger implements Logger<Level> {

    private final java.util.logging.Logger internalLogger;

    public JulLogger() throws DefinitionException {

        StdLogLevel level = service(Configuration.class).get(LOG_LEVEL);
        Level logLevel = service(Configuration.class).has(LOG_LEVEL) ?
            StdLogLevelToOwnLogLevel(level) :
            Level.ALL;

        internalLogger = java.util.logging.Logger.getLogger("");
        internalLogger.setUseParentHandlers(false);
        if (internalLogger.getHandlers().length > 0) {
            Arrays.stream(internalLogger.getHandlers()).forEach(internalLogger::removeHandler);
        }
        internalLogger.setLevel(logLevel);

        // console logging
        if (service(Configuration.class).has(ENABLE_LOG_TO_CONSOLE) &&
            service(Configuration.class).get(ENABLE_LOG_TO_CONSOLE)) {

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new JulFormatter(this));
            consoleHandler.setLevel(logLevel);
            internalLogger.addHandler(consoleHandler);
        }

        // file logging
        if (service(Configuration.class).has(ENABLE_LOG_TO_FILE) &&
            service(Configuration.class).get(ENABLE_LOG_TO_FILE)) {

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
                internalLogger.addHandler(fileHandler);
            } catch (IOException e) {
                throw new DefinitionException(e);
            }
        }

        info("I've been successfully defined");
    }


    @Override
    public void debug(String message, Object... parameters) {
        internalLogger.finest(format(message, parameters));
    }

    @Override
    public void info(String message, Object... parameters) {
        internalLogger.info(format(message, parameters));
    }

    @Override
    public void warn(String message, Object... parameters) {
        internalLogger.warning(format(message, parameters));
    }

    @Override
    public void error(String message, Object... parameters) {
        internalLogger.severe(format(message, parameters));
    }

    @Override
    public void error(Exception exception) {
        error(exceptionToMessage(exception));
    }

    @Override
    public StdLogLevel ownLogLevelToStdLogLevel(Level level) {
        return
            level.equals(Level.ALL) || level.equals(Level.FINEST) || level.equals(Level.FINER) || level.equals(Level.FINE) ? StdLogLevel.DBUG :
                level.equals(Level.CONFIG) || level.equals(Level.INFO) ? StdLogLevel.INFO :
                    level.equals(Level.WARNING) ? StdLogLevel.WARN :
                        level.equals(Level.SEVERE) ? StdLogLevel.ERRO :
                            StdLogLevel.NONE;
    }

    @Override
    public Level StdLogLevelToOwnLogLevel(StdLogLevel level) {
        return
            level.equals(StdLogLevel.DBUG) ? Level.ALL :
                level.equals(StdLogLevel.INFO) ? Level.INFO :
                    level.equals(StdLogLevel.WARN) ? Level.WARNING :
                        level.equals(StdLogLevel.ERRO) ? Level.SEVERE :
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
