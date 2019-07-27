package org.fluentness.base.service.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.fluentness.base.service.config.Config;

import static org.fluentness.base.service.config.BooleanKey.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.service.config.StringKey.LOG_LEVEL;

public class DefaultLogger implements Logger {

    private org.apache.log4j.Logger logger;

    public DefaultLogger() {

        logger = org.apache.log4j.Logger.getLogger(this.getClass());
        BasicConfigurator.configure();

        if (service(Config.class).has(LOG_LEVEL)) {
            logger.setLevel(Level.toLevel(service(Config.class).get(LOG_LEVEL)));
        } else {
            logger.setLevel(Level.ALL);
        }

        if (service(Config.class).is(ENABLE_LOG_TO_CONSOLE)) {
            logger.addAppender(new ConsoleAppender());
        }

        if (service(Config.class).is(ENABLE_LOG_TO_CONSOLE)) {
            logger.addAppender(new FileAppender());
        }
    }

    @Override
    public void trace(String message, Object... parameters) {
        logger.trace(format(message, parameters));
    }

    @Override
    public void debug(String message, Object... parameters) {
        logger.debug(format(message, parameters));
    }

    @Override
    public void info(String message, Object... parameters) {
        logger.info(format(message, parameters));
    }

    @Override
    public void warn(String message, Object... parameters) {
        logger.warn(format(message, parameters));
    }

    @Override
    public void error(String message, Object... parameters) {
        logger.error(format(message, parameters));
    }

    @Override
    public void fatal(String message, Object... parameters) {
        logger.fatal(format(message, parameters));
    }

    @Override
    public void fatal(Exception exception) {
        String message;
        if (exception.getMessage() == null) {
            message = exception.getClass().getSimpleName() + ":";
        } else {
            message = exception.getClass().getSimpleName() + " " + exception.getMessage() + ":";
        }
        message = message.concat(stackTraceToString(exception.getStackTrace()));
        error(message);
    }
}
