package org.fluentness.common.logging;

import org.fluentness.common.constants.AnsiColors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

abstract class AbstractFormatter extends Formatter implements AnsiColors {

    void appendLogRecordTitle(StringBuilder builder, LogRecord record) {
        builder.append("[");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        builder.append(df.format(new Date(record.getMillis())));
        builder.append("] [");
        builder.append(Logger.toNormalLogLevel(record.getLevel().getName()));
        builder.append("] [");
        builder.append(Thread.currentThread().getStackTrace()[10].getClassName());
        builder.append("]");
    }

}
