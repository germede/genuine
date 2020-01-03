package org.fluentness.controller.desktop.style.property;

public class Property<K, V> {
    private final K selector;
    private final PropertyLambda<V> styleLambda;

    public Property(K selector, PropertyLambda<V> styleLambda) {
        this.selector = selector;
        this.styleLambda = styleLambda;
    }

    public K getSelector() {
        return selector;
    }

    public PropertyLambda<V> getStyleLambda() {
        return styleLambda;
    }
}
