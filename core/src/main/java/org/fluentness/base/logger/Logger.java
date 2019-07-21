package org.fluentness.base.logger;

public interface Logger {
    void initialize();

    java.util.logging.Logger getInternalLogger();

    void setInternalLogger(java.util.logging.Logger internalLogger);

    void fine(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warning(String message, Object... parameters);

    void severe(String message, Object... parameters);

    void severe(Exception exception);
}
