package org.fluentness.base.service.logger;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.fluentness.base.common.constant.AnsiColors.*;

public class DefaultLayout extends Layout {
    @Override
    public String format(LoggingEvent loggingEvent) {
        StringBuilder builder = new StringBuilder();
        switch (loggingEvent.getLevel().toInt()) {
            case Level.TRACE_INT:
            case Level.DEBUG_INT:
                builder.append(ANSI_GREEN);
                break;
            case Level.INFO_INT:
                builder.append(ANSI_BLUE);
                break;
            case Level.WARN_INT:
                builder.append(ANSI_YELLOW);
                break;

            case Level.ERROR_INT:
            case Level.FATAL_INT:
                builder.append(ANSI_RED);
                break;
        }
        builder.append("[");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        builder.append(df.format(new Date(loggingEvent.getTimeStamp())));
        builder.append("] [");
        builder.append(loggingEvent.getLevel().toString());
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (!stackTraceElement.getClassName().startsWith("java") &&
                !stackTraceElement.getClassName().startsWith(AbstractAppender.class.getPackage().getName())) {
                builder.append("] [");
                builder.append(stackTraceElement.getClassName().replaceAll(".*\\.",""));
                break;
            }
        }
        builder.append("]");
        builder.append(ANSI_RESET);
        builder.append(ANSI_RESET);
        builder.append(" ");
        builder.append(loggingEvent.getMessage());
        builder.append("\n");
        return builder.toString();
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public void activateOptions() {

    }
}
