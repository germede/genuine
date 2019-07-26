package org.fluentness.flow.producer.form;

import org.fluentness.base.common.lambda.KeyValuePair;
import org.fluentness.flow.producer.view.MarkupAttributes;
import org.fluentness.flow.producer.view.MarkupElement;
import org.fluentness.flow.producer.view.MarkupElementContainer;
import org.fluentness.flow.producer.view.View;

public class Form extends MarkupElementContainer {

    Form(String methodValue, String actionValue, KeyValuePair<Field>[] fields) {
        super("form");
        attributes = new MarkupAttributes(method -> methodValue, action -> actionValue);
        innerViews = new View[fields.length];
        for (int i = 0; i < fields.length; i++) {
            KeyValuePair<Field> field = fields[i];
            Field fieldInstance = field.getValue();
            fieldInstance.attributes.add(name -> field.getKey());
            innerViews[i] = fieldInstance;
        }
    }

    public Form precededBy(View... predecessors) {
        return (Form) super.precededBy(predecessors);
    }

    public Form wrappedBy(MarkupElement wrapper) {
        return (Form) super.wrappedBy(wrapper);
    }

    public Form followedBy(View... successors) {
        return (Form) super.followedBy(successors);
    }
}
