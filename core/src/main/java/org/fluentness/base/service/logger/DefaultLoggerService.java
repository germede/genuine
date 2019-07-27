package org.fluentness.base.service.logger;

import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.ConfigService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.base.service.config.BooleanKey.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.service.config.BooleanKey.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.service.config.StringKey.LOG_LEVEL;

public class DefaultLoggerService implements LoggerService {

    private java.util.logging.Logger internalLogger;

    public DefaultLoggerService() throws DefinitionException {

        internalLogger = java.util.logging.Logger.getLogger(String.valueOf(System.currentTimeMillis()));
        internalLogger.setUseParentHandlers(false);

        String logLevel = "ALL";
        if (consumeService(ConfigService.class).has(LOG_LEVEL)) {
            logLevel = consumeService(ConfigService.class).get(LOG_LEVEL);
        }

        internalLogger.setLevel(Level.parse(logLevel));

        // console logging
        if (consumeService(ConfigService.class).has(ENABLE_LOG_TO_CONSOLE) && consumeService(ConfigService.class).get(ENABLE_LOG_TO_CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            consoleHandler.setLevel(Level.parse(logLevel));
            internalLogger.addHandler(consoleHandler);
        }

        // file logging
        try {
            if (consumeService(ConfigService.class).has(ENABLE_LOG_TO_FILE) && consumeService(ConfigService.class).get(ENABLE_LOG_TO_FILE)) {
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
                fileHandler.setFormatter(new FileFormatter());
                fileHandler.setLevel(Level.parse(logLevel));
                internalLogger.addHandler(fileHandler);

            }
        } catch (IOException e) {
            throw new DefinitionException(e);
        }
    }

    @Override
    public void fine(String message, Object... parameters) {
        internalLogger.fine(format(message, parameters));
    }

    @Override
    public void info(String message, Object... parameters) {
        internalLogger.info(format(message, parameters));
    }

    @Override
    public void warning(String message, Object... parameters) {
        internalLogger.warning(format(message, parameters));
    }

    @Override
    public void severe(String message, Object... parameters) {
        internalLogger.severe(format(message, parameters));
    }

    @Override
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
}
