package org.fluentness.service.logger;

import android.util.Log;
import org.fluentness.service.common.AnsiColor;

import java.util.logging.Level;

import static org.fluentness.service.common.AnsiColor.*;

public enum LogLevel {
    NONE(null),
    ERROR(RED),
    WARNING(YELLOW),
    INFO(BLUE),
    DEBUG(GREEN);

    public static LogLevel fromJulLevel(Level julLevel) {
        return julLevel.equals(Level.ALL) || julLevel.equals(Level.FINEST) || julLevel.equals(Level.FINER) || julLevel.equals(Level.FINE) ? DEBUG :
                julLevel.equals(Level.CONFIG) || julLevel.equals(Level.INFO) ? INFO :
                        julLevel.equals(Level.WARNING) ? WARNING :
                                julLevel.equals(Level.SEVERE) ? ERROR :
                                        LogLevel.NONE;
    }

    public static LogLevel fromAndroidPriority(int androidPriority) {
        switch (androidPriority) {
            case Log.ASSERT:
            case Log.ERROR:
                return ERROR;
            case Log.WARN:
                return WARNING;
            case Log.INFO:
                return INFO;
            case Log.DEBUG:
            case Log.VERBOSE:
            default:
                return DEBUG;
        }
    }

    private AnsiColor ansiColor;

    LogLevel(AnsiColor ansiColor) {
        this.ansiColor = ansiColor;
    }

    public AnsiColor getAnsiColor() {
        return ansiColor;
    }

    @Override
    public String toString() {
        switch (this) {
            case DEBUG:
                return "DBUG";
            case INFO:
                return "INFO";
            case WARNING:
                return "WARN";
            case ERROR:
                return "ERRO";
            default:
                return "NONE";
        }
    }

    public Level toJulLevel() {
        return this.equals(LogLevel.DEBUG) ? Level.ALL :
                this.equals(LogLevel.INFO) ? Level.INFO :
                        this.equals(LogLevel.WARNING) ? Level.WARNING :
                                this.equals(LogLevel.ERROR) ? Level.SEVERE :
                                        Level.OFF;
    }

    public int toAndroidPriority() {
        return this.equals(LogLevel.DEBUG) ? Log.DEBUG :
                this.equals(LogLevel.INFO) ? Log.INFO :
                        this.equals(LogLevel.WARNING) ? Log.WARN :
                                this.equals(LogLevel.ERROR) ? Log.ERROR :
                                        Log.ASSERT;
    }
}
