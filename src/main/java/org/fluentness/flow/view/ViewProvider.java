package org.fluentness.flow.view;

import org.fluentness.common.constants.ViewPlaceholders;
import org.fluentness.common.generics.Provider;
import org.fluentness.flow.localization.Localizable;

public abstract class ViewProvider implements Provider<View>, Localizable, HtmlFunctions {

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

    protected View using(View template, View toInclude) {
        return toInclude.setTemplate(template);
    }
}
