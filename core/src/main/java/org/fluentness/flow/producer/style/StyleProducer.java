package org.fluentness.flow.producer.style;

import org.fluentness.flow.producer.Producer;
import org.fluentness.base.common.lambda.KeyValuePair;

public abstract class StyleProducer extends Producer<Style> {

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
