package org.fluentness.view.component;

import java.util.HashMap;
import java.util.Map;

public class HtmlComponent implements Component {

    static int HTML_ID = 0;
    protected final int id = HTML_ID++;
    protected final String tag;

    private final Map<String, CharSequence> attributes = new HashMap<>();

    public HtmlComponent(String tag) {
        this.tag = tag;
        withAttribute("id", String.valueOf(id));
    }

    public int getId() {
        return id;
    }

    public HtmlComponent withAttribute(String key, CharSequence value) {
        if (attributes.containsKey(key)) attributes.put(key, attributes.get(key) + " " + value);
        else attributes.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        for (Map.Entry<String, CharSequence> attribute : this.attributes.entrySet()) {
            attributes.append(' ').append(attribute.getKey())
                .append(attribute.getValue() == null ? "" : "=\"" + attribute.getValue() + "\"");
        }
        return "<" + tag + attributes + ">";
    }
}
