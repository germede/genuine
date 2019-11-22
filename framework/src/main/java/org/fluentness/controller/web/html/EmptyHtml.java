package org.fluentness.controller.web.html;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EmptyHtml implements Html {

    private String tag;
    private Attribute[] attributes;

    public EmptyHtml(String tag, Attribute[] attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String getTag() {
        return tag;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    @Override
    public String render() {
        return "<" + tag + Arrays.stream(attributes).map(Attribute::render).collect(Collectors.joining()) + "/>";
    }
}
