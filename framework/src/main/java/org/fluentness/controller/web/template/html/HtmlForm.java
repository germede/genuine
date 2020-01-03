package org.fluentness.controller.web.template.html;

import org.fluentness.repository.Model;

import java.lang.reflect.Method;

public class HtmlForm<T> extends HtmlElement {


    public HtmlForm(Model model, Method action) {
//        super("form", renderForm(model, action));
        super("asdf", null);
    }
//
//    private static Html[] renderForm(Model model, Method action) {
//        List<Html> result = new LinkedList<>();
//        result.add(_method(action.getHttpMethod()));
//        result.add(_action(action.getPath()));
//        Arrays.stream(model.getGetters())
//            .map(getter -> input(getHtmlAttributesFor(model, getter)))
//            .forEach(result::add);
//        result.add(input(_class("button"), _type("submit"), _value("Submit")));
//        return result.toArray(new Html[0]);
//    }
//
//    private static HtmlAttribute[] getHtmlAttributesFor(Object object, Method getter) {
//        List<HtmlAttribute> result = new LinkedList<>();
//        try {
//            getter.setAccessible(true);
//            result.add(_name(getter.getName()));
//            result.add(_type(getter.getAnnotation(Model.Type.class).value().name()));
//            result.add(_value(getter.invoke(object) == null ? "" : String.valueOf(getter.invoke(object))));
//            getter.setAccessible(false);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return result.toArray(new HtmlAttribute[0]);
//    }

}
