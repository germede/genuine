package org.fluentness.rendering;

public class MarkupInner implements Renderable {

    private String text;

    public MarkupInner(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}
