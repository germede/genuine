package org.fluentness.form;


import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.view.MarkupElementEmpty;
import org.fluentness.view.MarkupElement;
import org.fluentness.view.View;

public class Field extends MarkupElementEmpty {

    Field(String fieldType, KeyValuePair<String>[] attributes) {
        super("input", attributes);
        this.attributes.add(type -> fieldType);
    }

    void setName(String fieldName) {
        this.attributes.add(name -> fieldName);
    }

    public Field precededBy(View... predecessors) {
        return (Field) super.precededBy(predecessors);
    }

    public Field wrappedBy(MarkupElement wrapper) {
        return (Field) super.wrappedBy(wrapper);
    }

    public Field followedBy(View... successors) {
        return (Field) super.followedBy(successors);
    }

}
