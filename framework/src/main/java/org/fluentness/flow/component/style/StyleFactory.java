package org.fluentness.flow.component.style;

import org.fluentness.base.common.lambda.KeyValuePair;

public interface StyleFactory {

    default Style css(CssSelector... selectors) {
        return new CssStyle(selectors);
    }

    default CssSelector select(String selector, KeyValuePair<String>... rules) {
        return new CssSelector(selector, rules);
    }

    default Style external(String path) {
        return new ExternalStyle(path);
    }

    default Style bundle(Style... styles) {
        return new BundleStyle(styles);
    }
}
