package org.fluentness.base.service.logger;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.*;
import org.fluentness.base.service.config.Config;

import java.io.IOException;

import static org.fluentness.base.service.config.Key.BooleanKey.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.service.config.Key.BooleanKey.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.service.config.Key.LevelKey.LOG_LEVEL;

public class DefaultLogger implements Logger {

    private org.apache.log4j.Logger logger;

    public DefaultLogger() {

        logger = org.apache.log4j.Logger.getLogger(this.getClass());

        if (service(Config.class).has(LOG_LEVEL)) {
            logger.setLevel(service(Config.class).get(LOG_LEVEL));
        } else {
            logger.setLevel(Level.ALL);
        }

        Layout layout = new DefaultLayout();

        if (service(Config.class).is(ENABLE_LOG_TO_CONSOLE)) {
            logger.removeAllAppenders();
            logger.addAppender(new ConsoleAppender(layout));
        }

        if (service(Config.class).is(ENABLE_LOG_TO_FILE)) {
            try {
                logger.addAppender(new FileAppender(layout,"out/log.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        org.apache.log4j.Logger newl = org.apache.log4j.Logger.getLogger("CATALINA");
        newl.trace("ASDF");

        BasicConfigurator.configure();

        logger.trace("asdf");
//        String filePath = "mylog.log";
//        PatternLayout layout = new PatternLayout("%-5p %d %m%n");
//        RollingFileAppender appender = null;
//        try {
//            appender = new RollingFileAppender(layout, filePath);
//            appender.setName("myFirstLog");
//            appender.setMaxFileSize("1MB");
//            appender.activateOptions();
//            org.apache.log4j.Logger.getRootLogger().addAppender(appender);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
