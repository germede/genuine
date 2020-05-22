package org.fluentness.service.log;

import org.fluentness.service.configuration.Configuration;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.*;

public class JulLog implements Log {

    protected final Logger logger;

    public JulLog(Configuration configuration) throws Exception {

        Level julLevel = configuration.get(LEVEL).toJulLevel();

        logger = Logger.getGlobal();
        logger.setUseParentHandlers(false);
        Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);
        logger.setLevel(julLevel);

        JulFormatter formatter = new JulFormatter();

        // console logging
        if (configuration.get(CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler(){
                @Override
                protected synchronized void setOutputStream(OutputStream outputStream) throws SecurityException {
                    super.setOutputStream(System.out);
                }

                @Override
                public void publish(LogRecord record) {
                    String loggerName = record.getLoggerName();
                    if (loggerName.startsWith("java.awt") || loggerName.startsWith("sun") || loggerName.startsWith("javax.swing")) {
                        return;
                    }
                    super.publish(record);
                }
            };
            consoleHandler.setFormatter(formatter);
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
            fileHandler.setFormatter(formatter);
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
