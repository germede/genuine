package org.fluentness.controller.web.markup;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ContainerMarkupView implements MarkupView {

    private String tag;
    private MarkupView[] innerViews;
    private String innerText;
    private Map<String, String> attributes = new HashMap<>();

    public ContainerMarkupView(String tag, MarkupView... inner) {
        this.tag = tag;
        this.innerViews = inner;
    }

    public ContainerMarkupView(String tag, String inner) {
        this.tag = tag;
        this.innerText = inner;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public Map<String, String> getAttributes() {
        return attributes;
    }

    public MarkupView[] getInnerViews() {
        return innerViews;
    }

    public String getInnerText() {
        return innerText;
    }


    @Override
    public MarkupView attr(String key, String value) {
        attributes.put(key, value);
        return this;
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        builder.append(tag);
        builder.append(
            attributes.entrySet().stream()
                .map(attribute -> " " + attribute.getKey() + "=\"" + attribute.getValue() + "\"")
                .collect(Collectors.joining())
        );
        builder.append(">");
        if (innerViews != null) {
            for (MarkupView markupView : innerViews) {
                builder.append(markupView.toString());
            }
        }
        if (innerText != null) {
            builder.append(innerText);
        }
        builder.append("</").append(tag).append(">");
        return builder.toString();
    }
}
