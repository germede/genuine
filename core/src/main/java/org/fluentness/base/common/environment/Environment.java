package org.fluentness.base.common.environment;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.common.environment.BooleanKey.*;
import static org.fluentness.base.common.environment.BooleanKey.ENABLE_STYLE_MINIFY;
import static org.fluentness.base.common.environment.IntegerKey.APP_PORT;
import static org.fluentness.base.common.environment.StringKey.*;

public abstract class Environment {

    private Map<Key, Object> settings = new HashMap<>();

    public <T> boolean has(Key<T> key) {
        return settings.containsKey(key);
    }

    public <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    protected <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }

    protected void setDefaultSettings() {
        set(APP_PROTOCOL, "http");
        set(APP_HOST, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, "ALL");
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);
    }

    public abstract void initialize();

}