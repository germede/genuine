package org.fluentness.service.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static org.fluentness.service.logger.AnsiColor.*;

public class JulFormatter extends Formatter {

    @Override
    public String format(LogRecord logRecord) {
        LogLevel logLevel = LogLevel.fromJulLevel(logRecord.getLevel());
        StringBuilder builder = new StringBuilder();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getDefault());
        builder.append(ANSI_WHITE);
        builder.append(df.format(new Date(logRecord.getMillis())));
        builder.append(" | ");
        builder.append(logLevel.getAnsiColor().toString());
        builder.append(logLevel.toString());
        builder.append(ANSI_WHITE);
        builder.append(" | ");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.getClassName().startsWith("java.lang.Thread") &&
                !stackTraceElement.getClassName().startsWith("java.util.logging") &&
                !stackTraceElement.getClassName().startsWith("org.fluentness.service.logger")) {
                builder.append(stackTraceElement.getClassName().replaceAll(".*\\.", ""));
                builder.append(": ");
                break;
            }
        }
        builder.append(logLevel.equals(LogLevel.ERROR) ? ANSI_RED : ANSI_WHITE);
        builder.append(logRecord.getMessage());
        builder.append("\n");
        return builder.toString();
    }


}
