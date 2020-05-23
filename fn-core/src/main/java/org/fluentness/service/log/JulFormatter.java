package org.fluentness.service.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static org.fluentness.service.log.AnsiColor.RED;
import static org.fluentness.service.log.AnsiColor.RESET;

public class JulFormatter extends Formatter {

    private final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    private final StringBuilder builder = new StringBuilder();
    {
        df.setTimeZone(TimeZone.getDefault());
    }

    @Override
    public String format(LogRecord logRecord) {
        LogLevel logLevel = JulLog.toLogLevel(logRecord.getLevel());
        builder.setLength(0);
        builder.append(df.format(new Date(logRecord.getMillis())));
        builder.append(" | ");
        builder.append(logLevel.getAnsiColor().toString());
        builder.append(logLevel.toString());
        builder.append(RESET);
        builder.append(" | ");
        builder.append(logLevel.equals(LogLevel.FATAL) ? RED : "");
        builder.append(logRecord.getMessage());
        builder.append(logLevel.equals(LogLevel.FATAL) ? RESET : "");
        builder.append("\n");
        return builder.toString();
    }
}
