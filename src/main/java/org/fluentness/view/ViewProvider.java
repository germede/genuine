package org.fluentness.view;

import org.fluentness.common.components.Provider;
import org.fluentness.localization.Localizable;

public abstract class ViewProvider implements Provider<View>, Localizable, HtmlFunctions {

    @Override
    public Class<View> getProducedComponentType() {
        return View.class;
    }

    protected View placeholder() {
        return new RawView(View.TEMPLATE_PLACEHOLDER);
    }

    protected View raw(String raw) {
        return new RawView(raw);
    }

    protected View using(View template, View toInclude) {
        return toInclude.setTemplate(template);
    }
}
