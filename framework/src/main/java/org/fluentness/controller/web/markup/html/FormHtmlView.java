package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.WebActionReference;
import org.fluentness.controller.web.markup.AttributeMarkupView;
import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.repository.field.FieldExtractor;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class FormHtmlView<T> extends ContainerHtmlView {


    public FormHtmlView(Object model, WebActionReference action) {
        super("form", renderForm(model, action));
    }

    private static MarkupView[] renderForm(Object object, WebActionReference action) {
        List<MarkupView> result = new LinkedList<>();
        result.add(_method(action.getMethod()));
        result.add(_action(action.getPath()));
        FieldExtractor.INSTANCE.getModelFields(object).stream()
            .map(field -> input(getHtmlAttributesFor(object, field)))
            .forEach(result::add);
        result.add(input(_class("button"), _type("submit"), _value("Submit")));
        return result.toArray(new MarkupView[0]);
    }

    private static AttributeMarkupView[] getHtmlAttributesFor(Object object, Field field) {
        List<AttributeMarkupView> result = new LinkedList<>();
        try {
            field.setAccessible(true);
            result.add(_name(field.getName()));
            result.add(_type(field.getAnnotation(org.fluentness.repository.field.Field.class).value().name()));
            result.add(_value(field.get(object) == null ? "" : String.valueOf(field.get(object))));
            field.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result.toArray(new AttributeMarkupView[0]);
    }

}
