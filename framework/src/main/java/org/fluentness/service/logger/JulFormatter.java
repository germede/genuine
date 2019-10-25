package org.fluentness.service.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static org.fluentness.controller.console.AnsiColor.*;

class JulFormatter extends Formatter {

    protected JulLoggerService logger;

    JulFormatter(JulLoggerService logger) {
        this.logger = logger;
    }

    @Override
    public String format(LogRecord logRecord) {
        StringBuilder builder = new StringBuilder();
        builder.append(ANSI_RESET);
        builder.append(ANSI_RESET);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd | HH:mm:ss");
        df.setTimeZone(TimeZone.getDefault());
        builder.append(df.format(new Date(logRecord.getMillis())));
        builder.append(" | ");
        switch (logger.ownLogLevelToFluentnessLogLevel(logRecord.getLevel())) {
            case ERROR:
                builder.append(ANSI_RED);
                break;
            case WARNING:
                builder.append(ANSI_YELLOW);
                break;
            case INFO:
                builder.append(ANSI_BLUE);
                break;
            case DEBUG:
                builder.append(ANSI_GREEN);
                break;
        }
        builder.append(logger.ownLogLevelToFluentnessLogLevel(logRecord.getLevel()).toString());
        builder.append(ANSI_RESET);
        builder.append(ANSI_RESET);
        builder.append(" | ");
        boolean nextOne = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (nextOne) {
                builder.append(stackTraceElement.getClassName().replaceAll(".*\\.", ""));
                builder.append(" logs: ");
                break;
            }

            if (stackTraceElement.getClassName().equals(LoggerService.class.getName())) {
                nextOne = true;
            }
        }
        if (!nextOne) {
            builder.append(logRecord.getSourceClassName().replaceAll(".*\\.", ""));
            builder.append(" logs: ");
        }
        builder.append(logRecord.getMessage());
        builder.append("\n");
        return builder.toString();
    }

}
