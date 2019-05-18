package org.fluentness.form;


import org.fluentness.common.NamedValue;
import org.fluentness.common.NamedValueImpl;
import org.fluentness.renderable.MarkupAttributes;
import org.fluentness.renderable.MarkupElement;
import org.fluentness.renderable.Renderable;

public abstract class Field extends MarkupElement {

    Field(String type, NamedValue<String>[] attributes) {
        super("input", new MarkupAttributes(attributes));
        this.attributes.add(TYPE -> type);
    }

    void setName(String name) {
        this.attributes.add(new NamedValueImpl("name",name));
    }

    public Field precededBy(Renderable... predecessors) {
        return (Field) super.precededBy(predecessors);
    }

    public Field wrappedBy(Renderable wrapper) {
        return (Field) super.wrappedBy(wrapper);
    }

    public Field followedBy(Renderable... successors) {
        return (Field) super.followedBy(successors);
    }

}
