package org.fluentness.flow.component.view;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ForEachView<T> extends View {

    private String parameter;
    private Function<T, View> function;

    ForEachView(String parameter, Function<T, View> function) {
        this.parameter = parameter;
        this.function = function;
    }

    @Override
    public String render() {
        Collection<T> collection = (Collection<T>) retrieveParameterForCurrentThread(parameter);
        return collection.stream().map(function).map(View::render).collect(Collectors.joining());
    }
}
