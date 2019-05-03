package org.fluentness.form;

import org.fluentness.view.HtmlView;

import java.util.ArrayList;
import java.util.List;

public interface Form extends HtmlView {

    String getMethod();



    Fields getFields();

    @Override
    default String render() {
        return form(


        ).render();
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
