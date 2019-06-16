package org.fluentness.configuration;

public class Setting {
    private String key;
    private Object value;

    Setting(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
