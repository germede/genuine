package org.fluentness.configuration;

import org.fluentness.common.components.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Configuration implements Component {

    public static Configuration INSTANCE;

    public void apply() {
        INSTANCE = this;
    }

    private Map<String, Object> settings = new HashMap<>();

    Configuration(Setting[] settings) {
        Arrays.stream(settings).forEach(setting -> this.settings.put(setting.getKey(), setting.getValue()));
    }

    public String getString(String key) {
        return String.valueOf(INSTANCE.settings.get(key));
    }

    public int getInt(String key) {
        return (int) INSTANCE.settings.get(key);
    }

    public boolean getBoolean(String key) {
        if (settings.containsKey(key)) {
            return (boolean) INSTANCE.settings.get(key);
        }
        return false;
    }

    public Object getObject(String key) {
        return INSTANCE.settings.get(key);
    }

    public Object getObjectOrDefault(String key, Object defaultObject) {
        if (INSTANCE.settings.containsKey(key)) {
            return INSTANCE.settings.get(key);
        }
        return defaultObject;
    }

}
