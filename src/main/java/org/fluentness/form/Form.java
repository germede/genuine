package org.fluentness.form;

import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.common.namedValues.NamedValueImpl;
import org.fluentness.view.MarkupAttributes;
import org.fluentness.view.MarkupElement;
import org.fluentness.view.View;

import java.util.HashMap;
import java.util.Map;

public class Form extends MarkupElement {

    private Map<String, Field> fields = new HashMap<>();

    Form(String method, String action, NamedValue<Field>... fields) {
        super("form", new MarkupAttributes(new NamedValueImpl("method", method), new NamedValueImpl("action", action)));
        this.isContainer = true;
        this.inner = new CharSequence[fields.length];
        for (int i = 0, fieldsLength = fields.length; i < fieldsLength; i++) {
            NamedValue<Field> field = fields[i];
            Field value = field.value();
            value.setName(field.name());
            this.fields.put(field.name(), value);
            this.inner[i] = value;
        }
    }

    public Field get(String name) {
        return fields.get(name);
    }

    public Form precededBy(View... predecessors) {
        return (Form) super.precededBy(predecessors);
    }

    public Form wrappedBy(View wrapper) {
        return (Form) super.wrappedBy(wrapper);
    }

    public Form followedBy(View... successors) {
        return (Form) super.followedBy(successors);
    }
}
