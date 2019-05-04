package org.fluentness.logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FileFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis())));
        builder.append("] [");
        builder.append(Logger.normalizeLoggerLevel(record.getLevel().getName()));
        builder.append("]");
        builder.append(" - ");
        builder.append(record.getMessage());
        builder.append("\n");
        return builder.toString();
    }

}
