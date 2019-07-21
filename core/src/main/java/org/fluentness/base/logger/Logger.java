package org.fluentness.base.logger;

public interface Logger {
    void initialize();



    void fine(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warning(String message, Object... parameters);

    void severe(String message, Object... parameters);

    void severe(Exception exception);
}
