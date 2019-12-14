package org.fluentness.logger;

import org.fluentness.configuration.Configuration;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class JulLogger implements Logger {

    protected final java.util.logging.Logger logger;

    public JulLogger(Configuration configuration) throws Exception {
        // retrieve log level
        Level julLevel = configuration.get(LEVEL).toJulLevel();

        // init jul logger
        logger = java.util.logging.Logger.getGlobal();
        logger.setUseParentHandlers(false);
        Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        logger.setLevel(julLevel);

        // console logging
        if (configuration.get(CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler(){
                @Override
                protected synchronized void setOutputStream(OutputStream outputStream) throws SecurityException {
                    super.setOutputStream(System.out);
                }
            };
            consoleHandler.setFormatter(new JulFormatter());
            consoleHandler.setLevel(julLevel);
            logger.addHandler(consoleHandler);
        }

        // file logging
        if (configuration.has(FILE)) {
            new File(configuration.get(FILE)).mkdirs();
            String logFilePath = configuration.get(FILE) + "/" +
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
            fileHandler.setLevel(julLevel);
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
    public void log(LogLevel logLevel, String message, Object... parameters) {
        logger.log(logLevel.toJulLevel(), String.format(message, parameters));
    }

}
