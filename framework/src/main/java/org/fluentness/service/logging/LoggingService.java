package org.fluentness.service.logging;

import org.fluentness.service.Service;

public interface LoggingService extends Service {

    void log(LogLevel logLevel, String message, Object... parameters);

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warning(String message, Object... parameters);

    void error(String message, Object... parameters);

    void error(Throwable throwable);
}

