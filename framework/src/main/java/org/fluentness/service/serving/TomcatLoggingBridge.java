package org.fluentness.service.serving;

import org.fluentness.service.logging.LogLevel;
import org.fluentness.service.logging.LoggingService;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TomcatLoggingBridge extends Handler {

    private final LoggingService loggingService;

    public TomcatLoggingBridge(LoggingService loggingService) {
        this.loggingService = loggingService;

    }
    @Override
    public void publish(LogRecord logRecord) {
        loggingService.log(LogLevel.fromJulLevel(logRecord.getLevel()), logRecord.getMessage());
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
