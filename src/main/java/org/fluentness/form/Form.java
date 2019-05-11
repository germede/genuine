package org.fluentness.form;

import org.fluentness.common.NamedValue;
import org.fluentness.rendering.MarkupElement;
import org.fluentness.rendering.MarkupFunctions;
import org.fluentness.rendering.Renderable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Form extends Renderable, MarkupFunctions, FieldFunctions {

    String getMethod();

    Fields getFields();

    @Override
    default String render() {
        return new MarkupElement("form",
                attrs(METHOD -> getMethod()),
                getFields().render()
        ).render();
    }

    default Fields fields(NamedValue<Field>... fields) {
        return new Fields(fields);
    }

    class Fields implements Renderable {

        private List<Field> fields = new ArrayList<>();

        private Fields(NamedValue<Field>... fields) {
            Arrays.stream(fields).forEach(field -> this.fields.add(field.value().setName(field.name())));
        }

        @Override
        public String render() {
            return fields.stream().map(Field::render).collect(Collectors.joining());
        }
    }
}
