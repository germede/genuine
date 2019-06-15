package org.fluentness.form;


import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.view.EmptyMarkupElement;
import org.fluentness.view.MarkupElement;

import java.util.Arrays;

public abstract class Field extends EmptyMarkupElement {

    Field(String type, KeyValuePair<String>[] attributes) {
        super("input");
        addAttribute("type", type);
        Arrays.stream(attributes).forEach(attribute->addAttribute(attribute.key(),attribute.value()));
    }

    void setName(String name) {
        addAttribute("name", name);
    }

    public Field precededBy(MarkupElement... predecessors) {
        return (Field) super.precededBy(predecessors);
    }

    public Field wrappedBy(MarkupElement wrapper) {
        return (Field) super.wrappedBy(wrapper);
    }

    public Field followedBy(MarkupElement... successors) {
        return (Field) super.followedBy(successors);
    }

}
