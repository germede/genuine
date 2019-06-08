package org.fluentness.form;

import org.fluentness.common.lambdas.NamedValueImpl;
import org.fluentness.view.ContainerMarkupElement;
import org.fluentness.view.MarkupElement;

import java.util.HashMap;
import java.util.Map;

public class Form extends ContainerMarkupElement {

    private Map<String, Field> fields = new HashMap<>();

    Form(String method, String action, MarkupElement[] fields) {
        super("form",fields);
        with(new NamedValueImpl("method", method), new NamedValueImpl("action", action));
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
