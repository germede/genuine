package org.fluentness.form;

import org.fluentness.common.NamedValue;
import org.fluentness.renderable.MarkupAttributes;
import org.fluentness.renderable.MarkupElement;
import org.fluentness.renderable.Renderable;
import org.fluentness.view.View;

import java.util.HashMap;
import java.util.Map;

public interface Form extends View.Html, FieldFunctions {

    String getAction();

    String getMethod();

    Fields getFields();

    default Fields fields(NamedValue<Field>... fields) {
        return new Fields(fields, getAction(), getMethod());
    }

    @Override
    default Renderable getRenderable() {
        return getFields();
    }

    class Fields extends MarkupElement {

        private Map<String, Field> fields = new HashMap<>();

        private Fields(NamedValue<Field>[] fields, String actionAttribute, String methodAttribute) {
            super("form", new MarkupAttributes(action -> actionAttribute, method -> methodAttribute));
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

        public Fields precededBy(Renderable... predecessors) {
            return (Fields) super.precededBy(predecessors);
        }

        public Fields wrappedBy(Renderable wrapper) {
            return (Fields) super.wrappedBy(wrapper);
        }

        public Fields followedBy(Renderable... successors) {
            return (Fields) super.followedBy(successors);
        }
    }
}
