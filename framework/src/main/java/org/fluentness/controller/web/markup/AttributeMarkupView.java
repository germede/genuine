package org.fluentness.controller.web.markup;

public class AttributeMarkupView implements MarkupView {

    private final String key;
    private final String value;

    public AttributeMarkupView(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String render() {
        return " " + key + "=\"" + value +"\"";
    }
}
