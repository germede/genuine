package org.fluentness.configuration;

import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Register;

import java.util.Arrays;

public class Configuration implements Component, Register<String, Object> {

    public static Configuration INSTANCE = new Configuration(null);

    private Setting[] settings;

    public Configuration(Setting[] settings) {
        this.settings = settings;
    }

    public void apply() {
        Arrays.stream(settings).forEach(setting -> INSTANCE.put(setting.key, setting.value));
    }

    public static String getString(String key) {
        return String.valueOf(INSTANCE.get(key));
    }

    public static int getInt(String key) {
        return (int) INSTANCE.get(key);
    }

    public static boolean getBoolean(String key) {
        if (INSTANCE.containsKey(key)) {
            return (boolean) INSTANCE.get(key);
        }
        return false;
    }

    public static Object getObject(String key) {
        return INSTANCE.get(key);
    }

    public static Object getObjectOrDefault(String key, Object defaultObject) {
        if (INSTANCE.containsKey(key)) {
            return INSTANCE.get(key);
        }
        return defaultObject;
    }
}
