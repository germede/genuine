package org.fluentness.base.service.config;

import org.apache.log4j.Level;

public interface Key<T> {

    enum IntegerKey implements Key<Integer> {
        APP_PORT,
        HIBERNATE_PORT,
    }

    enum LevelKey implements Key<Level> {
        LOG_LEVEL
    }

    enum StringKey implements Key<String> {
        APP_PROTOCOL,
        APP_HOSTNAME,
        APP_KEYSTORE,
        PERSISTENCE_UNIT
    }

    enum BooleanKey implements Key<Boolean> {
        ENABLE_CACHE,
        ENABLE_LOG_VERBOSE,
        ENABLE_LOG_TO_CONSOLE,
        ENABLE_LOG_TO_FILE,
        ENABLE_STYLE_MINIFY
    }
}
