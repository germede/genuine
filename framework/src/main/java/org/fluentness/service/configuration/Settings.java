package org.fluentness.service.configuration;

import java.util.HashMap;
import java.util.Map;

public class Settings {

    private static Environment defaultEnvironment;
    private static Map<String, Map<Environment, String>> settingsMap;

    private Map<Environment, String> settings = new HashMap<>();
    private Settings next;
    private String key;

    public Settings(Environment defaultEnvironment) {
        Settings.defaultEnvironment = defaultEnvironment;
    }

    private Settings(String key) {
        this.key = key;
    }

    String getSetting(String key, Environment environment) {
        if (settingsMap == null) {
            settingsMap = new HashMap<>();
            Settings current = this;
            while (current.next != null) {
                settingsMap.put(current.key, current.settings);
                current = current.next;
            }
        }
        Map<Environment, String> environmentStringMap = settingsMap.get(key);
        if (environmentStringMap != null) {
            return environmentStringMap.getOrDefault(environment,"");
        } else {
            return key;
        }
    }

    public Settings add(String key) {
        Settings next = new Settings(key);
        this.next = next;
        return next;
    }

    public Settings dev(String value) {
        settings.put(Environment.DEV, value);
        return this;
    }

    public Settings test(String value) {
        settings.put(Environment.TEST, value);
        return this;
    }

    public Settings prod(String value) {
        settings.put(Environment.PROD, value);
        return this;
    }
}
