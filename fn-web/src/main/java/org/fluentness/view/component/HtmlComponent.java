package org.fluentness.view.component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HtmlComponent implements Component {

    private static int ID_SEQUENCE = 0;

    protected int id = ++ID_SEQUENCE;
    protected final String tag;
    protected HtmlComponent parent;

    protected final Map<String, Set<CharSequence>> attributes = new HashMap<>();

    public HtmlComponent(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public String getXpath() {
        int siblingIndex = 1;
        if (parent instanceof HtmlContainer) {
            for (HtmlComponent htmlComponent : ((HtmlContainer) parent).getInnerHtml()) {
                if (htmlComponent.equals(this)) break;
                if (htmlComponent.getTag().equals(this.getTag())) siblingIndex++;
            }
        }
        return parent == null ?
            tag + "[" + siblingIndex + "]" :
            parent.getXpath() + "/" + (tag + "[" + siblingIndex + "]");
    }

    public void setParent(HtmlComponent parent) {
        this.parent = parent;
    }

    public HtmlComponent withAttribute(String key, Object value) {
        if (!attributes.containsKey(key)) attributes.put(key, new HashSet<>());
        attributes.get(key).add(String.valueOf(value));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        for (Map.Entry<String, Set<CharSequence>> attribute : this.attributes.entrySet()) {
            attributes.append(' ').append(attribute.getKey())
                .append(attribute.getValue() != null ? "=\"" + String.join(" ", attribute.getValue()) + "\"" : "");
        }
        return "<" + tag + attributes + "/>";
    }
}
