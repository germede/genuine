package org.fluentness.view.component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.view.component.HtmlAttribute.SEPARATOR;

public class HtmlComponent implements CharSequence, Component {

    static int HTML_ID = 0;
    protected final int id = HTML_ID++;
    protected final String tag;

    protected final Map<String, String> attributes = new HashMap<>();

    public HtmlComponent(String tag) {
        this.tag = tag;
    }

    public HtmlComponent(String tag, String[] attributes) {
        this(tag);
        Arrays.stream(attributes).forEach(this::addAttribute);
    }

    {
        addAttribute(HtmlAttribute.ID + String.valueOf(id));
    }

    public int getId() {
        return id;
    }

    public void addAttribute(String attribute) {
        String[] split = attribute.substring(SEPARATOR.length()).split(SEPARATOR);
        if (split.length == 1) {
            attributes.put(split[0], null);
        } else {
            if (attributes.containsKey(split[0])) {
                attributes.put(split[0], attributes.get(split[0]) + split[1]);
            } else {
                attributes.put(split[0], split[1]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        for (Map.Entry<String, String> attribute : this.attributes.entrySet()) {
            attributes.append(' ').append(attribute.getKey())
                .append(attribute.getValue() == null ? "" : "=\"" + attribute.getValue() + "\"");
        }
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
