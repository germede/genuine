package org.fluentness.service.persistence;

import org.apache.openjpa.lib.log.AbstractLog;
import org.apache.openjpa.lib.log.Log;
import org.fluentness.service.logger.LoggerService;

class OpenJpaLoggingBridge extends AbstractLog {
    private LoggerService loggerService;

    OpenJpaLoggingBridge(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    protected boolean isEnabled(short logLevel) {
        return true;
    }

    protected void log(short type, String message, Throwable t) {
        switch (type) {
            case Log.FATAL:
            case Log.ERROR:
                loggerService.error(message);
                break;
            case Log.WARN:
                loggerService.warning(message);
                break;
            case Log.INFO:
                loggerService.info(message);
                break;
            case Log.TRACE:
                loggerService.debug(message);
        }
    }
}
