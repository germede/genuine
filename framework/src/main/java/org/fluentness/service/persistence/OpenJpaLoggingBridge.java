package org.fluentness.service.persistence;

import org.apache.openjpa.lib.log.AbstractLog;
import org.apache.openjpa.lib.log.Log;
import org.apache.openjpa.lib.log.LogFactory;
import org.fluentness.service.logger.Logger;

public class OpenJpaLoggingBridge extends AbstractLog implements LogFactory {

    private final Logger logger;

    OpenJpaLoggingBridge(Logger logger) {
        this.logger = logger;
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
                logger.error(message);
                break;
            case Log.WARN:
                logger.warning(message);
                break;
            case Log.INFO:
                logger.info(message);
                break;
            case Log.TRACE:
                logger.debug(message);
        }
    }
}























