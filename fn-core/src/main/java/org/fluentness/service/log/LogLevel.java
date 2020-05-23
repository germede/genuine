package org.fluentness.service.log;

import static org.fluentness.service.log.AnsiColor.*;

public enum LogLevel {
    TRACE(WHITE, "TRACE", 6),
    DEBUG(CYAN, "DEBUG", 5),
    INFO(BLUE, "INFO ", 4),
    WARN(YELLOW, "WARN ", 3),
    ERROR(RED, "ERROR", 2),
    FATAL(RED, "FATAL", 1);

    private final AnsiColor ansiColor;
    private final String toString;
    private final int priority;

    LogLevel(AnsiColor ansiColor, String toString, int priority) {
        this.ansiColor = ansiColor;
        this.toString = toString;
        this.priority = priority;
    }

    public AnsiColor getAnsiColor() {
        return ansiColor;
    }

    @Override
    public String toString() {
        return toString;
    }

    public int getPriority() {
        return priority;
    }
}
