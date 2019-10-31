package org.fluentness.controller.web.markup;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmptyMarkupView implements MarkupView {

    private String tag;
    private Map<String, String> attributes = new HashMap<>();

    public EmptyMarkupView(String tag) {
        this.tag = tag;
    }

    @Override
    public MarkupView attr(String key, String value) {
        attributes.put(key, value);
        return this;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public Map<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public String render() {
        return "<" + tag + attributes.entrySet().stream()
            .map(attribute -> " " + attribute.getKey() + "=\"" + attribute.getValue() + "\"")
            .collect(Collectors.joining()) + "/>";
    }
}
