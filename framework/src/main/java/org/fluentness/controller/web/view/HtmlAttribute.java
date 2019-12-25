package org.fluentness.controller.web.view;

public class HtmlAttribute implements HtmlView {

    private final String key, value;

    public HtmlAttribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return " " + key + "=\"" + value + "\"";
    }
}
