package org.fluentness.controller.web.html;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.controller.web.WebView;
import org.fluentness.repository.Model;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.web.html.HtmlFactory.*;

public class HtmlForm<T> extends HtmlContainer {


    public HtmlForm(Object model, WebAction action) {
        super("form", renderForm(model, action));
    }

    private static WebView[] renderForm(Object object, WebAction action) {
        String[] pathParts = AbstractWebController.getPath(action).split(" ");
        List<WebView> result = new LinkedList<>();
        result.add(_method(pathParts[0]));
        result.add(_action(pathParts[1]));
        Model.getModelFields(object).stream()
            .map(field -> input(getHtmlAttributesFor(object, field)))
            .forEach(result::add);
        result.add(input(_class("button"), _type("submit"), _value("Submit")));
        return result.toArray(new WebView[0]);
    }

    private static HtmlAttribute[] getHtmlAttributesFor(Object object, Field field) {
        List<HtmlAttribute> result = new LinkedList<>();
        try {
            field.setAccessible(true);
            result.add(_name(field.getName()));
            result.add(_type(field.getAnnotation(Model.Field.class).value().name()));
            result.add(_value(field.get(object) == null ? "" : String.valueOf(field.get(object))));
            field.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result.toArray(new HtmlAttribute[0]);
    }

}
