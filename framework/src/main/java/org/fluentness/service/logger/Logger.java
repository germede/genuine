package org.fluentness.service.logger;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

@Singleton
public interface Logger extends Service {

    Key<LogLevel> logger_level = new Key<>();
    Key<Boolean> logger_console = new Key<>();
    Key<String> logger_file = new Key<>();

    void log(LogLevel logLevel, String message, Object... parameters);

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warning(String message, Object... parameters);

    void error(String message, Object... parameters);

    void error(Throwable throwable);
}

