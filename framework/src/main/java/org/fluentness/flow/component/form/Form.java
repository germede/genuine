package org.fluentness.flow.component.form;

import org.fluentness.base.common.lambda.KeyValuePairLambda;
import org.fluentness.flow.component.view.MarkupAttributes;
import org.fluentness.flow.component.view.MarkupElement;
import org.fluentness.flow.component.view.MarkupElementContainer;
import org.fluentness.flow.component.view.View;

public class Form extends MarkupElementContainer {

    Form(String methodValue, String actionValue, KeyValuePairLambda<Field>[] fields) {
        super("form");
        attributes = new MarkupAttributes(method -> methodValue, action -> actionValue);
        innerViews = new View[fields.length];
        for (int i = 0; i < fields.length; i++) {
            KeyValuePairLambda<Field> field = fields[i];
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
