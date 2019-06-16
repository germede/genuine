package org.fluentness.style;

import org.fluentness.common.generics.Provider;
import org.fluentness.common.lambdas.KeyValuePair;

public abstract class StyleProvider implements Provider<Style> {

    @Override
    public Class<Style> getProducedComponentType() {
        return Style.class;
    }

    protected Style css(CssSelector... selectors) {
        return new CssStyle(selectors);
    }

    protected CssSelector select(String selector, KeyValuePair<String>... rules) {
        return new CssSelector(selector, rules);
    }

    protected Style external(String path) {
        return new ExternalStyle(path);
    }

    protected Style bundle(Style... styles) {
        return new BundleStyle(styles);
    }
}
