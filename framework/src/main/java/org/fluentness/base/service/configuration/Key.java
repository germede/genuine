package org.fluentness.base.service.configuration;

import org.fluentness.base.service.logger.FluentnessLogLevel;

public interface Key<T> {

    enum Integer implements Key<java.lang.Integer> {
        APP_PORT,

    }

    enum String implements Key<java.lang.String> {
        APP_PROTOCOL,
        APP_HOSTNAME,
        PERSISTENCE_UNIT,
    }

    enum Boolean implements Key<java.lang.Boolean> {
        ENABLE_CACHE,
        ENABLE_LOG_TO_CONSOLE,
        ENABLE_LOG_TO_FILE,
        ENABLE_STYLE_MINIFY
    }

    enum LogLevel implements Key<FluentnessLogLevel> {
        LOG_LEVEL,
    }
}
