package org.fluentness.base.settings;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.settings.BooleanKey.*;
import static org.fluentness.base.settings.IntegerKey.APP_PORT;
import static org.fluentness.base.settings.StringKey.*;

public enum Settings {
    instance();

    private Map<Key, Object> settings;

    Settings() {
        initialize();
    }

    void initialize() {
        settings = new HashMap<>();

        // default settings
        set(APP_PROTOCOL, "http");
        set(APP_HOST, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, "ALL");
        set(PERSISTENCE_UNIT, "default");
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, true);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);
    }

    public <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }

    public <T>T get(Key<T> key) {
        return (T) settings.get(key);
    }

    void clear() {
        settings.clear();
    }
}
