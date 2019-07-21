package org.fluentness.base.config;

import static org.fluentness.base.config.BooleanKey.*;
import static org.fluentness.base.config.BooleanKey.ENABLE_STYLE_MINIFY;
import static org.fluentness.base.config.IntegerKey.APP_PORT;
import static org.fluentness.base.config.StringKey.*;

public interface Config {
    void initialize();

    <T>T get(Key<T> key);

    <T> void set(Key<T> key, T value);

    <T> boolean has(Key<T> key);

    default void setDefaultSettings() {
        set(APP_PROTOCOL, "http");
        set(APP_HOST, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, "ALL");
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);
    }
}
