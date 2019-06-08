package org.fluentness.form;


import org.fluentness.common.lambdas.NamedValue;
import org.fluentness.common.lambdas.NamedValueImpl;
import org.fluentness.view.EmptyMarkupElement;
import org.fluentness.view.MarkupElement;

public abstract class Field extends EmptyMarkupElement {

    Field(String type, NamedValue<String>[] attributes) {
        super("input", attributes);
        addAttribute(TYPE -> type);
    }

    void setName(String name) {
        addAttribute(new NamedValueImpl("name",name));
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
