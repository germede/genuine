package org.fluentness.flow.view;

import org.fluentness.base.constants.ViewPlaceholders;
import org.fluentness.base.generics.Provider;
import org.fluentness.flow.localization.Translator;

import java.util.function.Function;

public abstract class ViewProvider implements Provider<View>, HtmlFunctions, Translator {

    @Override
    public Class<View> getProducedComponentType() {
        return View.class;
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
