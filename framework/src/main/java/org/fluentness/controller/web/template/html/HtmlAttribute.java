package org.fluentness.controller.web.template.html;

public class HtmlAttribute implements Html {

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
