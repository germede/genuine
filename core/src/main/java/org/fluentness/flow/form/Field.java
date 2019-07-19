package org.fluentness.flow.form;


import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.flow.view.MarkupElement;
import org.fluentness.flow.view.MarkupElementEmpty;
import org.fluentness.flow.view.View;

public class Field extends MarkupElementEmpty {

    Field(String fieldType, KeyValuePair<String>[] attributes) {
        super("input", attributes);
        this.attributes.add(type -> fieldType);
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
