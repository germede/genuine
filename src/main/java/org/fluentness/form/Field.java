package org.fluentness.form;


import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.common.namedValues.NamedValueImpl;
import org.fluentness.view.MarkupAttributes;
import org.fluentness.view.MarkupElement;
import org.fluentness.view.View;

public abstract class Field extends MarkupElement {

    Field(String type, NamedValue<String>[] attributes) {
        super("input", new MarkupAttributes(attributes));
        this.attributes.add(TYPE -> type);
    }

    void setName(String name) {
        this.attributes.add(new NamedValueImpl("name",name));
    }

    public Field precededBy(View... predecessors) {
        return (Field) super.precededBy(predecessors);
    }

    public Field wrappedBy(View wrapper) {
        return (Field) super.wrappedBy(wrapper);
    }

    public Field followedBy(View... successors) {
        return (Field) super.followedBy(successors);
    }

}
