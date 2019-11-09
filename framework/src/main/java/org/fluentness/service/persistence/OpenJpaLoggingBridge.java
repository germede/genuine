package org.fluentness.service.persistence;

import org.apache.openjpa.lib.log.AbstractLog;
import org.apache.openjpa.lib.log.Log;
import org.apache.openjpa.lib.log.LogFactory;
import org.fluentness.service.logging.LoggingService;

public class OpenJpaLoggingBridge extends AbstractLog implements LogFactory {

    private final LoggingService loggingService;

    OpenJpaLoggingBridge(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public Log getLog(String channel) {
        return this;
    }

    @Override
    protected boolean isEnabled(short logLevel) {
        return true;
    }

    @Override
    protected void log(short type, String message, Throwable t) {
        switch (type) {
            case Log.FATAL:
            case Log.ERROR:
                loggingService.error(message);
                break;
            case Log.WARN:
                loggingService.warning(message);
                break;
            case Log.INFO:
                loggingService.info(message);
                break;
            case Log.TRACE:
                loggingService.debug(message);
        }
    }
}























