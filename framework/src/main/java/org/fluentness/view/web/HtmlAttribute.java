package org.fluentness.view.web;

public class HtmlAttribute implements WebView {

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
