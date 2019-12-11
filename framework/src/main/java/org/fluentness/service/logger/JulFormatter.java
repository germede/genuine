package org.fluentness.service.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static org.fluentness.service.common.AnsiColor.ANSI_RED;
import static org.fluentness.service.common.AnsiColor.ANSI_RESET;

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
        builder.append(Logger.getLoggerCaller());
        builder.append(": ");
        builder.append(logRecord.getMessage());
        builder.append(logLevel.equals(LogLevel.ERROR) ? ANSI_RESET : "");
        builder.append("\n");
        return builder.toString();
    }


}
