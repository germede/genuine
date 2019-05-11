package org.fluentness.form;

import org.fluentness.common.NamedValue;
import org.fluentness.localization.Localizable;
import org.fluentness.rendering.HtmlFunctions;
import org.fluentness.rendering.Renderable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface Form extends Renderable, HtmlFunctions, FieldFunctions, Localizable {

    String getMethod();

    String getAction();

    Fields getFields();

    Renderable getRenderable();

    default Fields fields(NamedValue<Field>... fields) {
        return new Fields(fields);
    }

    default Field field(String name) {
        return getFields().get(name);
    }

    @Override
    default String render() {
        return form(attrs(METHOD -> getMethod(), ACTION -> getAction()),
                getRenderable()
        ).render();
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
