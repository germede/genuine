package org.fluentness.service.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static org.fluentness.service.logging.AnsiColor.ANSI_RED;
import static org.fluentness.service.logging.AnsiColor.ANSI_RESET;

public class JulFormatter extends Formatter {

    @Override
    public String format(LogRecord logRecord) {
        LogLevel logLevel = LogLevel.fromJulLevel(logRecord.getLevel());
        StringBuilder builder = new StringBuilder();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getDefault());
        builder.append(df.format(new Date(logRecord.getMillis())));
        builder.append(" | ");
        builder.append(logLevel.getAnsiColor().toString());
        builder.append(logLevel.toString());
        builder.append(ANSI_RESET);
        builder.append(" | ");
        builder.append(logLevel.equals(LogLevel.ERROR) ? ANSI_RED : "");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.getClassName().startsWith("java.lang.Thread") &&
                !stackTraceElement.getClassName().startsWith("java.util.logging") &&
                !stackTraceElement.getClassName().startsWith(getClass().getPackage().getName())) {
                builder.append(stackTraceElement.getClassName().replaceAll(".*\\.", ""));
                builder.append(": ");
                break;
            }
        }
        builder.append(logRecord.getMessage());
        builder.append(logLevel.equals(LogLevel.ERROR) ? ANSI_RESET : "");
        builder.append("\n");
        return builder.toString();
    }


}
