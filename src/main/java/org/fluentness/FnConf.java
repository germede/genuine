package org.fluentness;

import org.fluentness.common.lambdas.NamedValue;

import java.util.HashMap;
import java.util.Map;

public final class FnConf {

    private static Map<String, Object> settingsMap = new HashMap<>();

    public static void setSettings(NamedValue<Object>[] settings) {
        for (NamedValue<Object> setting : settings) {
            settingsMap.put(setting.name().toUpperCase(), setting.value());
        }
    }

    public static String getString(String setting) {
        return String.valueOf(settingsMap.get(setting));
    }

    public static int getInt(String setting) {
        return (int) settingsMap.get(setting);
    }

    public static boolean getBoolean(String setting) {
        if (settingsMap.containsKey(setting)) {
            return (boolean) settingsMap.get(setting);
        }
        return true;
    }

    public static Object getObject(String setting) {
        if (settingsMap.containsKey(setting)) {
            return settingsMap.get(setting);
        }
        return null;
    }

    public static Object getOrDefault(String setting, Object defaultObject) {
        if (settingsMap.containsKey(setting)) {
            return settingsMap.get(setting);
        }
        return defaultObject;
    }

    public static boolean contains(String setting) {
        return settingsMap.containsKey(setting);
    }
}
