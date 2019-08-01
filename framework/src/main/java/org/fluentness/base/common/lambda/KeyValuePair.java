package org.fluentness.base.common.lambda;

public class KeyValuePair<T> {

    private String key;
    private T value;

    public KeyValuePair(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}