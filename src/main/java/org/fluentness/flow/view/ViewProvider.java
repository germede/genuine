package org.fluentness.flow.view;

import org.fluentness.common.constants.ViewPlaceholders;
import org.fluentness.common.generics.Provider;

import java.util.function.Function;

public abstract class ViewProvider implements Provider<View>, HtmlFunctions {

    @Override
    public Class<View> getProducedComponentType() {
        return View.class;
    }

    protected String translate(String name) {
        return String.format(ViewPlaceholders.LOCALIZATION_PLACEHOLDER, name);
    }

    protected View placeholder() {
        return new RawView(ViewPlaceholders.TEMPLATE_PLACEHOLDER);
    }

    protected View raw(String raw) {
        return new RawView(raw);
    }

    protected View basedOn(View template, View toInclude) {
        return toInclude.setTemplate(template);
    }

    protected View print(String parameter) {
        return new ParameterView(parameter);
    }

    protected <T> View forEachItemIn(String parameter, Class<T> itemClass, Function<T, View> function) {
        return new ForEachView(parameter, function);
    }
}
