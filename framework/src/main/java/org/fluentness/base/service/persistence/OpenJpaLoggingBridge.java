package org.fluentness.base.service.persistence;

import org.apache.openjpa.lib.log.AbstractLog;
import org.apache.openjpa.lib.log.Log;
import org.fluentness.base.Base;
import org.fluentness.base.service.logger.Logger;

class OpenJpaLoggingBridge extends AbstractLog implements Base.Consumer {

    private Logger logger = service(Logger.class);

    protected boolean isEnabled(short logLevel) {
        return true;
    }

    protected void log(short type, String message, Throwable t) {
        switch (type) {
            case Log.FATAL:
            case Log.ERROR:
                logger.error(message);
                break;
            case Log.WARN:
                logger.warn(message);
                break;
            case Log.INFO:
                logger.info(message);
                break;
            case Log.TRACE:
                logger.debug(message);
                break;
        }
    }
}
