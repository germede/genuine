package org.fluentness.controller.web.markup;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EmptyMarkupView implements MarkupView {

    private String tag;
    private AttributeMarkupView[] attributes;

    public EmptyMarkupView(String tag, AttributeMarkupView[] attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String getTag() {
        return tag;
    }

    public AttributeMarkupView[] getAttributes() {
        return attributes;
    }

    @Override
    public String render() {
        return "<" + tag + Arrays.stream(attributes).map(AttributeMarkupView::render).collect(Collectors.joining()) + "/>";
    }
}
