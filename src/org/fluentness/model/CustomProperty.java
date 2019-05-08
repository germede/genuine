package org.fluentness.model;

public class CustomProperty extends Property {

    private final Class type;

    public CustomProperty(Class type) {
        this.type = type;
    }

    public Class getType() {
        return type;
    }
}
