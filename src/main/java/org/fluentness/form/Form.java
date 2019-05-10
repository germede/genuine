package org.fluentness.form;

import org.fluentness.common.NamedValue;
import org.fluentness.rendering.Renderable;
import org.fluentness.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Form extends View.Html, FieldFunctions {

    String getMethod();

    Fields getFields();

    @Override
    default Renderable getRenderable() {
        return form(attrs(METHOD -> getMethod()),
                String.join("", getFields().fields.toString())
        );
    }

    default Fields fields(NamedValue<Field>... fields) {
        return new Fields(fields);
    }

    class Fields {

        private List<Field> fields = new ArrayList<>();

        private Fields(NamedValue<Field>... fields) {
            Arrays.stream(fields).forEach(field -> this.fields.add(field.value().setName(field.name())));
        }
    }
}
