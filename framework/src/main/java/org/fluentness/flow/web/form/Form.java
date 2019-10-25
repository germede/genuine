package org.fluentness.flow.web.form;

import org.fluentness.base.server.HttpMethod;
import org.fluentness.base.common.lambda.KeyValuePairLambda;
import org.fluentness.flow.web.markup.MarkupAttributes;
import org.fluentness.flow.web.markup.MarkupElement;
import org.fluentness.flow.web.markup.MarkupElementContainer;
import org.fluentness.flow.View;

public class Form extends MarkupElementContainer {

    Form(HttpMethod methodValue, String actionValue, KeyValuePairLambda<Field>[] fields) {
        super("form");
        attributes = new MarkupAttributes(method + methodValue, action -> actionValue);
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


Base -> Services
Data -> Repositories -> Models
Flow -> Providers -> Factories -> Components