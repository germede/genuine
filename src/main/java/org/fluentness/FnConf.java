package org.fluentness;

import org.fluentness.configuration.Configuration;

public enum FnConf {

    INSTANCE;

    private Configuration configuration;

    void apply(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getString(String key) {
        return String.valueOf(INSTANCE.configuration.get(key));
    }

    public int getInt(String key) {
        return (int) INSTANCE.configuration.get(key);
    }

    public boolean getBoolean(String key) {
        if (configuration.containsKey(key)) {
            return (boolean) INSTANCE.configuration.get(key);
        }
        return false;
    }

    public Object getObject(String key) {
        return INSTANCE.configuration.get(key);
    }

    public Object getObjectOrDefault(String key, Object defaultObject) {
        if (INSTANCE.configuration.containsKey(key)) {
            return INSTANCE.configuration.get(key);
        }
        return defaultObject;
    }

}
