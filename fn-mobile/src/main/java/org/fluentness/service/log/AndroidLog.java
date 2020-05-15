package org.fluentness.service.log;

import org.fluentness.service.configuration.Configuration;

import static org.fluentness.service.log.LogLevel.*;

public class AndroidLog implements Log {

    private final int androidPriority;

    public AndroidLog(Configuration configuration) {
        this.androidPriority = toAndroidPriority(configuration.get(LEVEL));
    }

    @Override
    public void debug(String message, Object... parameters) {
        log(LogLevel.DEBUG, message, parameters);
    }

    @Override
    public void info(String message, Object... parameters) {
        log(INFO, message, parameters);
    }

    @Override
    public void warning(String message, Object... parameters) {
        log(WARNING, message, parameters);
    }

    @Override
    public void error(String message, Object... parameters) {
        log(ERROR, message, parameters);
    }

    @Override
    public void log(LogLevel logLevel, String message, Object... parameters) {
        if (toAndroidPriority(logLevel) >= androidPriority) {
            android.util.Log.println(toAndroidPriority(logLevel), Log.getLoggerCaller(), String.format(message, parameters));
        }
    }


    protected LogLevel fromAndroidPriority(int androidPriority) {
        switch (androidPriority) {
            case android.util.Log.ASSERT:
            case android.util.Log.ERROR:
                return ERROR;
            case android.util.Log.WARN:
                return WARNING;
            case android.util.Log.INFO:
                return INFO;
            case android.util.Log.DEBUG:
            case android.util.Log.VERBOSE:
            default:
                return DEBUG;
        }
    }


    protected int toAndroidPriority(LogLevel logLevel) {
        return logLevel.equals(LogLevel.DEBUG) ? android.util.Log.DEBUG :
            logLevel.equals(INFO) ? android.util.Log.INFO :
                logLevel.equals(WARNING) ? android.util.Log.WARN :
                    logLevel.equals(ERROR) ? android.util.Log.ERROR :
                        android.util.Log.ASSERT;
    }


}
