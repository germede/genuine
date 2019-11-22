package org.fluentness.controller.web.html;

public class HtmlAttribute implements Html {

    private final String key;
    private final String value;

    public HtmlAttribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String render() {
        return " " + key + "=\"" + value +"\"";
    }
}
