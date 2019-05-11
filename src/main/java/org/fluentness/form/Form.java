package org.fluentness.form;

import org.fluentness.common.NamedValue;
import org.fluentness.rendering.HtmlFunctions;
import org.fluentness.rendering.Renderable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface Form extends Renderable, HtmlFunctions, FieldFunctions {

    String getMethod();

    Fields getFields();

    default Fields fields(NamedValue<Field>... fields) {
        return new Fields(fields);
    }

    default Field field(String name) {
        return getFields().get(name);
    }

    class Fields {

        private Map<String, Field> fields = new HashMap<>();

        private Fields(NamedValue<Field>... fields) {
            Arrays.stream(fields).forEach(field -> {
                field.value().setName(field.name());
                this.fields.put(field.name(), field.value());
            });
        }

        public Field get(String name) {
            return fields.get(name);
        }
    }
}
