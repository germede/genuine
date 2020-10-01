package org.fluentness.service.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static org.fluentness.service.log.AnsiColor.RESET;

public class JulFormatter extends Formatter {

    private final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    private final StringBuilder builder = new StringBuilder();
    {
        df.setTimeZone(TimeZone.getDefault());
    }

    @Override
    public String format(LogRecord logRecord) {
        LogLevel logLevel = LogLevel.toLogLevel(logRecord.getLevel());
        builder.setLength(0);
        builder.append(df.format(new Date(logRecord.getMillis())));
        builder.append(logLevel.getAnsiColor().toString());
        String level = logLevel.toString();
        builder.append(new String(new char[8 - level.length()]).replace("\0", " "));
        builder.append(level);
        builder.append(RESET);
        builder.append(" | ");
        builder.append(logLevel.ordinal() > LogLevel.INFO.ordinal() ? logLevel.getAnsiColor() : "");
        builder.append(logRecord.getMessage());
        builder.append(logLevel.ordinal() > LogLevel.INFO.ordinal() ? RESET : "");
        builder.append("\n");

        return builder.toString();
    }
}
