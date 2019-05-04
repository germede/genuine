package org.fluentness.logging;

import org.fluentness.common.AnsiColors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static java.util.logging.Level.SEVERE;

public class ConsoleFormatter extends Formatter implements AnsiColors {

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        if (record.getLevel().intValue() == Level.FINE.intValue()) {
            builder.append(ANSI_GREEN);
        } else if (record.getLevel().intValue() == Level.INFO.intValue()) {
            builder.append(ANSI_BLUE);
        } else if (record.getLevel().intValue() == Level.WARNING.intValue()) {
            builder.append(ANSI_YELLOW);
        } else if (record.getLevel().intValue() == SEVERE.intValue()) {
            builder.append(ANSI_RED);
        }
        builder.append("[");
        builder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis())));
        builder.append("] [");
        builder.append(Logger.normalizeLoggerLevel(record.getLevel().getName()));
        builder.append("]");
        builder.append(ANSI_RESET);
        builder.append(ANSI_RESET);
        builder.append(" - ");
        builder.append(record.getMessage());
        builder.append("\n");
        return builder.toString();
    }
}