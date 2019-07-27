package org.fluentness.base.service.logger;

import org.apache.log4j.Appender;
import org.fluentness.base.common.constant.AnsiColors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.LogRecord;

abstract class AbstractAppender implements Appender, AnsiColors {



    void appendLogRecordTitle(StringBuilder builder, LogRecord logRecord) {
        builder.append("[");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        builder.append(df.format(new Date(logRecord.getMillis())));
        builder.append("] [");
        builder.append(logRecord.getLevel().getName());
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (!stackTraceElement.getClassName().startsWith("java") &&
                !stackTraceElement.getClassName().startsWith(AbstractAppender.class.getPackage().getName())) {
                builder.append("] [");
                builder.append(stackTraceElement.getClassName().replaceAll(".*\\.",""));
                break;
            }
        }
        builder.append("]");
    }

}
