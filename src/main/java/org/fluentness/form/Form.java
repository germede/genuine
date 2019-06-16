package org.fluentness.form;

import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.common.generics.Component;
import org.fluentness.view.MarkupElementContainer;
import org.fluentness.view.MarkupAttributes;
import org.fluentness.view.MarkupElement;
import org.fluentness.view.View;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Form extends MarkupElementContainer implements Component {

    private Map<String, Field> fields = new HashMap<>();

    Form(String methodValue, String actionValue, KeyValuePair<Field>[] fields) {
        super("form", new MarkupAttributes(method -> methodValue, action -> actionValue), Arrays.stream(fields).map(KeyValuePair::getValue).toArray(MarkupElement[]::new));
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
