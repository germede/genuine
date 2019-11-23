package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HtmlEmpty implements WebView {

    private String tag;
    private HtmlAttribute[] attributes;

    public HtmlEmpty(String tag, HtmlAttribute[] attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String getTag() {
        return tag;
    }

    public HtmlAttribute[] getAttributes() {
        return attributes;
    }

    @Override
    public String render() {
        return "<" + tag + Arrays.stream(attributes).map(HtmlAttribute::render).collect(Collectors.joining()) + "/>";
    }
}
