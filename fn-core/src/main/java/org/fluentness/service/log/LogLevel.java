package org.fluentness.service.log;

import static org.fluentness.service.log.AnsiColor.*;

public enum LogLevel {
    NONE(null),
    ERROR(RED),
    WARN(YELLOW),
    INFO(BLUE),
    DEBUG(GREEN),
    TRACE(WHITE);

    private final AnsiColor ansiColor;

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
            case WARN:
                return "WARN";
            case ERROR:
                return "ERRO";
            default:
                return "NONE";
        }
    }
}
