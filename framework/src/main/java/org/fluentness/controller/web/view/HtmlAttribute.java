package org.fluentness.controller.web.view;

import org.fluentness.controller.web.WebView;

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
