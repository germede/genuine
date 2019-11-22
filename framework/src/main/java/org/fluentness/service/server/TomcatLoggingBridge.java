package org.fluentness.service.server;

import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.Logger;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TomcatLoggingBridge extends Handler {

    private final Logger logger;

    public TomcatLoggingBridge(Logger logger) {
        this.logger = logger;

    }
    @Override
    public void publish(LogRecord logRecord) {
        logger.log(LogLevel.fromJulLevel(logRecord.getLevel()), logRecord.getMessage());
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
