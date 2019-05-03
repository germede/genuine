package org.fluentness.form;

import org.fluentness.rendering.Renderable;

import java.util.ArrayList;
import java.util.List;

public interface Form extends Renderable {

    String getMethod();

    Fields getFields();

    @Override
    default String render() {
        StringBuilder result = new StringBuilder();
        getFields().fields.forEach(field -> result.append(field.render()));
        return result.toString();
    }

    class Fields {

        private List<Field> fields = new ArrayList<>();

        public Fields add(Field field) {
            fields.add(field);
            return this;
        }

        public List<Field> get(String name) {
            return fields;
        }

    }
}
