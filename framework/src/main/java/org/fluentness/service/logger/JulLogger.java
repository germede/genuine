package org.fluentness.service.logger;

import org.fluentness.service.configurator.Configurator;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static org.fluentness.service.configurator.Configurator.*;

public class JulLogger implements Logger {

    protected final java.util.logging.Logger logger;

    public JulLogger(Configurator configurator) throws Exception {
        // retrieve log level
        Level logLevel = configurator.getOrDefault(logger_level, LogLevel.DEBUG).toJulLevel();

        // init jul logger
        logger = java.util.logging.Logger.getGlobal();
        logger.setUseParentHandlers(false);
        Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        logger.setLevel(logLevel);

        // console logging
        if (configurator.getOrDefault(logger_console, true)) {
            ConsoleHandler consoleHandler = new ConsoleHandler(){
                @Override
                protected synchronized void setOutputStream(OutputStream outputStream) throws SecurityException {
                    super.setOutputStream(System.out);
                }
            };
            consoleHandler.setFormatter(new JulFormatter());
            consoleHandler.setLevel(logLevel);
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (configurator.has(logger_file)) {
            new File(configurator.get(logger_file)).mkdirs();
            String logFilePath = configurator.get(logger_file) + "/" +
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
