package org.fluentness.service.log;

import java.util.logging.Level;

import static org.fluentness.service.log.AnsiColor.*;

public enum LogLevel {
    TRACE(WHITE),
    DEBUG(CYAN),
    INFO(BLUE),
    WARNING(YELLOW),
    ERROR(RED),
    FATAL(RED);

    private final AnsiColor ansiColor;

    LogLevel(AnsiColor ansiColor) {
        this.ansiColor = ansiColor;
    }

    public static LogLevel toLogLevel(Level julLevel) {
        return julLevel.equals(Level.ALL) || julLevel.equals(Level.FINEST) || julLevel.equals(Level.FINER) ? TRACE :
            julLevel.equals(Level.FINE) ? DEBUG :
                julLevel.equals(Level.CONFIG) || julLevel.equals(Level.INFO) ? INFO :
                    julLevel.equals(Level.WARNING) ? WARNING :
                        julLevel.equals(Level.SEVERE) ? ERROR :
                            INFO;
    }

    public Level toJulLevel() {
        switch (this) {
            case TRACE:
                return Level.ALL;
            case DEBUG:
                return Level.FINE;
            case INFO:
                return Level.INFO;
            case WARNING:
                return Level.WARNING;
            case FATAL:
            case ERROR:
                return Level.SEVERE;
            default:
                return Level.OFF;
        }
    }
    public AnsiColor getAnsiColor() {
        return ansiColor;
    }

}
