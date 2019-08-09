package org.fluentness.base.service.logger;

import org.fluentness.base.service.Service;

public class LoggerService implements Service {

    private Logger logger;

    public LoggerService(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Logger getComponent() {
        return logger;
    }

    public void debug(String message, Object... parameters) {
        logger.log(LogLevel.DBUG, message, parameters);
    }

    public void info(String message, Object... parameters) {
        logger.log(LogLevel.INFO, message, parameters);
    }

    public void warn(String message, Object... parameters) {
        logger.log(LogLevel.WARN, message, parameters);
    }

    public void error(String message, Object... parameters) {
        logger.log(LogLevel.ERRO, message, parameters);
    }

    public void error(Exception exception) {
        logger.log(exception);
    }
}

