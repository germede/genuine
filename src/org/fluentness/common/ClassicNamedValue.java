package org.fluentness.common;

public class ClassicNamedValue implements NamedValue {
    private String name;
    private Object value;

    public ClassicNamedValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Object apply(Object o) {
        return null;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Object value() {
        return value;
    }
}
