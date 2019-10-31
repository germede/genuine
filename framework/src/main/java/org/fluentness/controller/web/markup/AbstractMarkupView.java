package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMarkupView extends WebView implements MarkupView {

    protected String tag;
    protected Map<String, String> attributes = new HashMap<>();
    protected MarkupView[] innerViews;
    protected String innerText;

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
        builder.append(attributes.isEmpty() ? "" : " ");
        builder.append(
            attributes.entrySet().stream()
                .map(attribute -> attribute.getKey() + "=\"" + attribute.getValue() + "\"")
                .collect(Collectors.joining(" "))
        );
        builder.append((innerText == null && innerViews == null) ? "/>" : ">");
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
