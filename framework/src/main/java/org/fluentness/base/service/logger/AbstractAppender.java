package org.fluentness.base.service.logger;

import org.apache.log4j.Appender;
import org.fluentness.base.common.constant.AnsiColors;

import java.util.logging.LogRecord;

abstract class AbstractAppender implements Appender, AnsiColors {



    void appendLogRecordTitle(StringBuilder builder, LogRecord logRecord) {

    }

}
