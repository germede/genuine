package org.fluentness.flow.component;

public abstract class Component {

    private String name;

    public String getName() {
        return name;
    }

    public Component setName(String name) {
        this.name = name;
        return this;
    }
}
