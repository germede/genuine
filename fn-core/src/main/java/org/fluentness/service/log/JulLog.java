package org.fluentness.service.log;

import org.fluentness.service.configuration.Configuration;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

import static org.fluentness.service.log.LogLevel.*;

public class JulLog implements Log {

    private final Configuration configuration;
    private final JulFormatter formatter = new JulFormatter();
    protected Logger logger;

    private final Level julLevel;

    public JulLog(Configuration configuration) throws Exception {
        this.configuration = configuration;
        julLevel = configuration.get(LEVEL).toJulLevel();

        logger = Logger.getLogger(this.getClass().getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(julLevel);
        Arrays.stream(logger.getHandlers()).forEach(logger::removeHandler);

        consoleHandler();
        fileHandler();
        bridge(julLevel);
    }

    private void consoleHandler() {
        if (configuration.get(CONSOLE)) {
            ConsoleHandler consoleHandler = new ConsoleHandler() {
                @Override
                protected synchronized void setOutputStream(OutputStream outputStream) throws SecurityException {
                    super.setOutputStream(System.out);
                }
            };
            consoleHandler.setFormatter(formatter);
            consoleHandler.setLevel(julLevel);
            logger.addHandler(consoleHandler);
        }
    }

    private void fileHandler() throws IOException {
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

    private void bridge(Level julLevel) {
        Logger defaultLogger = Logger.getLogger("");
        defaultLogger.setLevel(julLevel);
        Arrays.stream(defaultLogger.getHandlers()).forEach(defaultLogger::removeHandler);
        defaultLogger.addHandler(new Handler() {
            @Override
            public void publish(LogRecord record) {
                LogLevel level = toLogLevel(record.getLevel());
                log(level, record.getMessage(), null);
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() throws SecurityException {
            }
        });
    }

    @Override
    public void log(LogLevel level, String message, Object[] parameters) {
        logger.log(level.toJulLevel(), String.format(message, parameters));
    }

}
