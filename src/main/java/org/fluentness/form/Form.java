package org.fluentness.form;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.onion.Component;
import org.fluentness.view.ContainerMarkupElement;
import org.fluentness.view.MarkupElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Form extends ContainerMarkupElement implements Component {

    private Map<String, Field> fields = new HashMap<>();

    Form(String methodValue, String actionValue, KeyValuePair<Field>[] fields) {
        super("form", Arrays.stream(fields).map(KeyValuePair::value).toArray(MarkupElement[]::new));
        attrs(method -> methodValue, action -> actionValue);
    }

    public Field get(String name) {
        return fields.get(name);
    }

    public Form precededBy(MarkupElement... predecessors) {
        return (Form) super.precededBy(predecessors);
    }

    public Form wrappedBy(MarkupElement wrapper) {
        return (Form) super.wrappedBy(wrapper);
    }

    public Form followedBy(MarkupElement... successors) {
        return (Form) super.followedBy(successors);
    }
}
