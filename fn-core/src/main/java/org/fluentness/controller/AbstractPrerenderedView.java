package org.fluentness.controller;

public abstract class AbstractPrerenderedView<V extends Template> implements View<V> {

    private final V template;

    public AbstractPrerenderedView() {
        // pre-render template
        template = getTemplate();
    }

    public final V getFinalTemplate() {
        return template;
    }

    @Override
    public V getTemplate() {
        return template;
    }
}
