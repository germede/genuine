package org.fluentness.service.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static org.fluentness.service.logger.AnsiColor.*;

class JulFormatter extends Formatter {

    protected JulLoggerService logger;

    JulFormatter(JulLoggerService logger) {
        this.logger = logger;
    }

    @Override
    public String format(LogRecord logRecord) {
        LogLevel logLevel = LogLevel.fromJulLevel(logRecord.getLevel());
        StringBuilder builder = new StringBuilder();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        builder.append(ANSI_WHITE);
        df.setTimeZone(TimeZone.getDefault());
        builder.append(df.format(new Date(logRecord.getMillis())));
        builder.append(" | ");
        builder.append(ANSI_RESET);
        builder.append(logLevel.getAnsiColor().toString());
        builder.append(logLevel.toString());
        builder.append(ANSI_RESET);
        builder.append(ANSI_WHITE);
        builder.append(" | ");
        builder.append(ANSI_RESET);
        builder.append(logLevel.equals(LogLevel.ERROR) ? ANSI_RED : ANSI_WHITE);
        builder.append(logRecord.getMessage());
        builder.append(ANSI_RESET);
        builder.append("\n");
        return builder.toString();
    }

}
