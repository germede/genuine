package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.WebActionReference;
import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.repository.Model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class FormHtmlView extends ContainerHtmlView {


    public FormHtmlView(Model model, WebActionReference action) {
        super("form", renderForm(model, action));
    }

    private static MarkupView[] renderForm(Model model, WebActionReference action) {
        List<MarkupView> result = new ArrayList<>();
        result.add(_method(action.getMethod()));
        result.add(_action(action.getPath()));
        for (Field field : model.getFields()) {
            try {
                field.setAccessible(true);
                Object o = field.get(model);
                result.add(
                    input(
                        _type(field.getAnnotation(Model.Field.class).type().name().toLowerCase()),
                        _name(field.getName()),
                        _value(o == null ? "" : String.valueOf(o))
                    )
                );
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
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


//    public FormHtmlView prepend(...) {
//
//        return this;
//    }
//
//    public FormHtmlView append(...) {
//
//        return this;
//    }
//
//    public FormHtmlView wrap(...) {
//
//        return this;
//    }

}
