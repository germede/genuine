package org.fluentness.service.log;

import org.fluentness.service.configuration.Configuration;

import static org.fluentness.service.log.LogLevel.*;

public class AndroidLog implements Log {

    private final int androidPriority;

    public AndroidLog(Configuration configuration) {
        this.androidPriority = toAndroidPriority(configuration.get(LEVEL));
    }

    @Override
    public void log(LogLevel logLevel, String message, Object... parameters) {
        if (toAndroidPriority(logLevel) >= androidPriority) {
            android.util.Log.println(toAndroidPriority(logLevel), "Fluentness", String.format(message, parameters));
        }
    }

    protected int toAndroidPriority(LogLevel logLevel) {
        return logLevel.equals(LogLevel.DEBUG) ? android.util.Log.DEBUG :
            logLevel.equals(INFO) ? android.util.Log.INFO :
                logLevel.equals(WARN) ? android.util.Log.WARN :
                    logLevel.equals(ERROR) ? android.util.Log.ERROR :
                        android.util.Log.ASSERT;
    }


}
