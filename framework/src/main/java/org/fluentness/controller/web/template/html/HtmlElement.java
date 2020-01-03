package org.fluentness.controller.web.template.html;

import java.util.Arrays;
import java.util.List;

public class HtmlElement implements Html {

    protected String tag;
    protected List<CharSequence> html;

    public HtmlElement(String tag, CharSequence... html) {
        this.tag = tag;
        this.html = Arrays.asList(html);
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        StringBuilder inner = new StringBuilder();
        for (CharSequence item : html) {
            String render = item.toString();
            if (item instanceof HtmlAttribute) {
                attributes.append(item);
            } else {
                inner.append(item);
            }
        }
        return "<" + tag + String.join(attributes) + (inner.length() == 0 ? "/>" : ">" + inner + "</" + tag + ">");
    }

    public HtmlElement add(String attribute) {
        html.add(attribute);
        return this;
    }
}
