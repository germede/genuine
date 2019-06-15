package org.fluentness.form;

import org.fluentness.base.generics.Component;
import org.fluentness.view.ContainerMarkupElement;
import org.fluentness.view.MarkupElement;

import java.util.HashMap;
import java.util.Map;

public class Form extends ContainerMarkupElement implements Component {

    private Map<String, Field> fields = new HashMap<>();

    Form(String methodValue, String actionValue, MarkupElement[] fields) {
        super("form",fields);
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
