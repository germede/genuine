package org.fluentness.view.component;

import org.fluentness.controller.JavaScriptCommand;
import org.fluentness.service.translator.Translator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HtmlComponent implements Component {

    private static long ID_SEQUENCE = 0;

    protected long id = ++ID_SEQUENCE;
    protected final String tag;
    protected HtmlComponent parent;

    protected final Map<String, Set<String>> attributes = new HashMap<>();

    public HtmlComponent(String tag) {
        this.tag = tag;
    }

    public long getId() {
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
        attributes.get(key).add(value == null ? "" : String.valueOf(value));
        return this;
    }

    public HtmlComponent withAttribute(String key) {
        return withAttribute(key, null);
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        for (Map.Entry<String, Set<String>> attribute : this.attributes.entrySet()) {
            attributes.append(' ').append(attribute.getKey()).append(attribute.getValue() != null ?
                "=\"" + attribute.getValue().stream().map(Translator::translate).collect(Collectors.joining(" ")) + "\""
                : ""
            );
        }
        return "<" + tag + attributes + "/>";
    }

    public void toggleClass(String clazz) {
        JavaScriptCommand.toggleClass(getXpath(), clazz);
    }
}
