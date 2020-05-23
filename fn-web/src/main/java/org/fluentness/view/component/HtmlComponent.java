package org.fluentness.view.component;

import java.util.Arrays;

import static org.fluentness.view.component.HtmlAttribute.SEPARATOR;

public class HtmlComponent implements CharSequence, Component {

    protected final String tag;
    protected final StringBuilder attributes = new StringBuilder();

    public HtmlComponent(String tag) {
        this.tag = tag;
    }

    public HtmlComponent(String tag, String[] attributes) {
        this(tag);
        Arrays.stream(attributes).forEach(this::addAttribute);
    }

    public void addAttribute(String attribute) {
        String[] split = attribute.substring(SEPARATOR.length()).split(SEPARATOR);
        attributes.append(' ').append(split[0]).append("=").append(split.length == 2 ? "\"" + split[1] + "\"" : "");
    }

    @Override
    public String toString() {
        return "<" + tag + attributes + ">";
    }

    @Override
    public final int length() {
        return 0;
    }

    @Override
    public final char charAt(int i) {
        return 0;
    }

    @Override
    public final CharSequence subSequence(int i, int i1) {
        return null;
    }
}
