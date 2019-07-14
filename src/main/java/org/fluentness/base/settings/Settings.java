package org.fluentness.base.settings;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.settings.BooleanKey.*;
import static org.fluentness.base.settings.IntegerKey.APP_PORT;
import static org.fluentness.base.settings.StringKey.*;

public enum Settings {
    call;

    private Map<Key, Object> settings = new HashMap<>();

    public void initialize() {
        // default settings
        setString(APP_PROTOCOL, "http");
        setString(APP_HOST, "localhost");
        setInteger(APP_PORT, 8000);
        setString(LOG_LEVEL, "ALL");
        setString(PERSISTENCE_UNIT, "default");
        setBoolean(ENABLE_LOG_TO_CONSOLE, true);
        setBoolean(ENABLE_LOG_TO_FILE, true);
        setBoolean(ENABLE_CACHE, true);
        setBoolean(ENABLE_STYLE_MINIFY, true);
    }

    public void setString(Key<String> key, String value) {
        settings.put(key,value);
    }

    public void setInteger(Key<Integer> key, Integer value) {
        settings.put(key,value);
    }

    public void setBoolean(Key<Boolean> key, Boolean value) {
        settings.put(key,value);
    }

    public String getString(Key<String> key) {
        return (String) settings.getOrDefault(key, "");
    }

    public Integer getInteger(Key<Integer> key) {
        return (Integer) settings.getOrDefault(key, 0);
    }

    public Boolean getBoolean(Key<Boolean> key) {
        return (Boolean) settings.getOrDefault(key, false);
    }
}
