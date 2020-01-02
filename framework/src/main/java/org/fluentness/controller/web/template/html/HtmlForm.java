package org.fluentness.controller.web.template.html;

import org.fluentness.repository.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.web.View.html.HtmlFactory.*;

public class HtmlForm<T> extends HtmlElement {


    public HtmlForm(Model model, WebAction action) {
        super("form", renderForm(model, action));
    }

    private static Html[] renderForm(Model model, WebAction action) {
        List<Html> result = new LinkedList<>();
        result.add(_method(action.getHttpMethod()));
        result.add(_action(action.getPath()));
        Arrays.stream(model.getGetters())
            .map(getter -> input(getHtmlAttributesFor(model, getter)))
            .forEach(result::add);
        result.add(input(_class("button"), _type("submit"), _value("Submit")));
        return result.toArray(new Html[0]);
    }

    private static HtmlAttribute[] getHtmlAttributesFor(Object object, Method getter) {
        List<HtmlAttribute> result = new LinkedList<>();
        try {
            getter.setAccessible(true);
            result.add(_name(getter.getName()));
            result.add(_type(getter.getAnnotation(Model.Type.class).value().name()));
            result.add(_value(getter.invoke(object) == null ? "" : String.valueOf(getter.invoke(object))));
            getter.setAccessible(false);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result.toArray(new HtmlAttribute[0]);
    }

}
