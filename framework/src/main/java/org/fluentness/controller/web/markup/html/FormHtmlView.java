package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.WebActionReference;
import org.fluentness.controller.web.markup.AttributeMarkupView;
import org.fluentness.controller.web.markup.MarkupView;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class FormHtmlView extends ContainerHtmlView {


    public FormHtmlView(Object model, WebActionReference action) {
        super("form", renderForm(model, action));
    }

    private static MarkupView[] renderForm(Object object, WebActionReference action) {
        List<MarkupView> result = new ArrayList<>();
        result.add(_method(action.getMethod()));
        result.add(_action(action.getPath()));
        for (Field field : object.getClass().getFields()) {
            result.add(input(getAttributesFor(object, field)));
        }
        result.add(
            input(
                _class("button"),
                _type("submit"),
                _value("Submit")
            )
        );
        return result.toArray(new MarkupView[0]);
    }

    private static AttributeMarkupView[] getAttributesFor(Object object, Field field) {
        List<AttributeMarkupView> result = new ArrayList<>();
        try {
            field.setAccessible(true);

            // field name
            result.add(_name(field.getName()));

            // field type
            String name = field.getName().toLowerCase();
            result.add(
                _type(field.getType().equals(Boolean.class) ? "checkbox" :
                    field.getType().equals(Date.class) ? "date" :
                        name.contains("time") ? "time" :
                            name.contains("password") ? "password" :
                                name.contains("color") ? "color" :
                                    name.contains("file") ? "file" :
                                        name.contains("email") ? "email" :
                                            name.contains("number") ? "number" :
                                                name.contains("radio") ? "radio" :
                                                    name.contains("range") ? "range" :
                                                        name.contains("submit") ? "submit" :
                                                            name.contains("tel") ? "tel" :
                                                                name.contains("url") ? "url" :
                                                                    "text")
            );

            // field value
            Object value = field.get(object);
            if (value != null) {
                result.add(_value(String.valueOf(value)));
            }

            field.setAccessible(false);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result.toArray(new AttributeMarkupView[0]);

    }

}
