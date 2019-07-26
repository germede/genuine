package org.fluentness.base.service.logger;

import java.util.logging.LogRecord;

public class FileFormatter extends AbstractFormatter {

    @Override
    public String format(LogRecord logRecord) {
        StringBuilder builder = new StringBuilder();
        appendLogRecordTitle(builder, logRecord);
        builder.append(" ");
        builder.append(logRecord.getMessage());
        builder.append("\n");
        return builder.toString();
    }

}
