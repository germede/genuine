package org.fluentness.controller.web.form;


import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.MarkupElement;
import org.fluentness.controller.web.markup.MarkupElementEmpty;

public class Field extends MarkupElementEmpty {

    Field(String fieldType, String[] attributes) {
        super("input", attributes);
//        this.attributes.add(type -> fieldType);
//        this.attributes.add("type -> fieldType");
    }

    public Field precededBy(WebView... predecessors) {
        return (Field) super.precededBy(predecessors);
    }

    public Field wrappedBy(MarkupElement wrapper) {
        return (Field) super.wrappedBy(wrapper);
    }

    public Field followedBy(WebView... successors) {
        return (Field) super.followedBy(successors);
    }

}
