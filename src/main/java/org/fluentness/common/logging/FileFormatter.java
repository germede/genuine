package org.fluentness.common.logging;

import java.util.logging.LogRecord;

public class FileFormatter extends AbstractFormatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        appendLogRecordTitle(builder, record);
        builder.append(" ");
        builder.append(record.getMessage());
        builder.append("\n");
        return builder.toString();
    }

}
