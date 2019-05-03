package org.fluentness.form;

import org.fluentness.view.HtmlView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Form extends HtmlView {

    String getMethod();

    Fields getFields();

    @Override
    default String render() {
        return form(attrs(METHOD -> getMethod()),
            getFields().fields.stream().collect(Collectors.joining())
        ).render();
    }

    class Fields {

        private List<Field> fields = new ArrayList<>();

        public Fields add(Field field) {
            fields.add(field);
            return this;
        }
    }
}
