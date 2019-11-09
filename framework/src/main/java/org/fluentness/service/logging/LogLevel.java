package org.fluentness.service.logging;

import java.util.logging.Level;

import static org.fluentness.service.logging.AnsiColor.*;

public enum LogLevel {
    NONE(null),
    ERROR(ANSI_RED),
    WARNING(ANSI_YELLOW),
    INFO(ANSI_BLUE),
    DEBUG(ANSI_GREEN);

    private AnsiColor ansiColor;

    LogLevel(AnsiColor ansiColor) {
        this.ansiColor = ansiColor;
    }

    public AnsiColor getAnsiColor() {
        return ansiColor;
    }

    public static LogLevel fromJulLevel(Level julLevel) {
        return julLevel.equals(Level.ALL) || julLevel.equals(Level.FINEST) || julLevel.equals(Level.FINER) || julLevel.equals(Level.FINE) ? DEBUG :
            julLevel.equals(Level.CONFIG) || julLevel.equals(Level.INFO) ? INFO :
                julLevel.equals(Level.WARNING) ? WARNING :
                    julLevel.equals(Level.SEVERE) ? ERROR :
                        LogLevel.NONE;
    }

    public Level toJulLevel() {
        return this.equals(LogLevel.DEBUG) ? Level.ALL :
            this.equals(LogLevel.INFO) ? Level.INFO :
                this.equals(LogLevel.WARNING) ? Level.WARNING :
                    this.equals(LogLevel.ERROR) ? Level.SEVERE :
                        Level.OFF;
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
}
