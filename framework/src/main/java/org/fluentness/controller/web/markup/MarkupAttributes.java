package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

public class MarkupAttributes extends WebView {

    private String[] attributes;

    public MarkupAttributes(String... attributes) {
        this.attributes = attributes;
    }

    @Override
    public String render() {
        for (int i = 0; i < attributes.length; i++) {
            String[] split = attributes[i].split("=");
            attributes[i] = split[0] + "=\"" + split[1] + "\"";
        }
        return String.join("",attributes);
    }
}
