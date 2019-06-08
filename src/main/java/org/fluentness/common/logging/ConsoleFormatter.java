package org.fluentness.common.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import static java.util.logging.Level.SEVERE;

public class ConsoleFormatter extends AbstractFormatter {

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
        appendLogRecordTitle(builder, record);
        builder.append(ANSI_RESET);
        builder.append(ANSI_RESET);
        builder.append(" ");
        builder.append(record.getMessage());
        builder.append("\n");
        return builder.toString();
    }
}