package org.fluentness.controller.web.control;

import org.fluentness.controller.web.WebView;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IfElseView<T> extends WebView {

    private String parameter;
    private Function<T, WebView> function;

    IfElseView(String condition, Function<T, WebView> function) {
        this.parameter = parameter;
        this.function = function;
    }

    @Override
    public String render() {
        Collection<T> collection = (Collection<T>) retrieveParameterForCurrentThread(parameter);
        return collection.stream().map(function).map(WebView::render).collect(Collectors.joining());
    }
}
