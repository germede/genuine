package org.fluentness.view.component;

import java.util.HashMap;
import java.util.Map;

public class HtmlComponent implements Component {

    private static int ID_SEQUENCE = 0;

    protected int id;
    protected final String tag;

    private final Map<String, CharSequence> attributes = new HashMap<>();

    public HtmlComponent(String tag) {
        this.tag = tag;
    }

    public int getId() {
        if (id == 0) {
            // only generate id if needed
            id = ID_SEQUENCE++;
            withAttribute("id", id);
        }
        return id;
    }

    public HtmlComponent withAttribute(String key, Object value) {
        if (attributes.containsKey(key)) attributes.put(key, attributes.get(key) + " " + value);
        else attributes.put(key, String.valueOf(value));
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
