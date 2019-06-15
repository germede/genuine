package org.fluentness.base.settings;

public enum Configuration {

    INSTANCE;

    static Settings settings;


    public String getString(String key) {
        return String.valueOf(settings.get(key));
    }

    public int getInt(String key) {
        return (int) settings.get(key);
    }

    public boolean getBoolean(String key) {
        if (settings.containsKey(key)) {
            return (boolean) settings.get(key);
        }
        return false;
    }

    public Object getObject(String key) {
        return settings.get(key);
    }

    public Object getObjectOrDefault(String key, Object defaultObject) {
        if (settings.containsKey(key)) {
            return settings.get(key);
        }
        return defaultObject;
    }

}
