package org.fluentness.flow.component.view;

import org.fluentness.flow.component.localization.Localizator;

import java.util.function.Function;

public interface ViewFactory extends HtmlFunctions, Localizator {

    default View placeholder() {
        return new RawView(ViewPlaceholders.TEMPLATE_PLACEHOLDER);
    }

    default View raw(String raw) {
        return new RawView(raw);
    }

    default View print(String parameter) {
        return new ParameterView(parameter);
    }

    default <T> View forEachItemIn(String parameter, Class<T> itemClass, Function<T, View> function) {
        return new ForEachView(parameter, function);
    }
}
