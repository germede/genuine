package org.fluentness.flow.web.form;


import org.fluentness.base.common.lambda.KeyValuePairLambda;
import org.fluentness.flow.web.markup.MarkupElement;
import org.fluentness.flow.web.markup.MarkupElementEmpty;
import org.fluentness.flow.View;

public class Field extends MarkupElementEmpty {

    Field(String fieldType, KeyValuePairLambda<String>[] attributes) {
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
