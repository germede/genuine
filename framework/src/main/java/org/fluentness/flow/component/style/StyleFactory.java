package org.fluentness.flow.component.style;

import org.fluentness.base.common.lambda.KeyValuePair;

public interface StyleFactory {

    default Style css(CssSelector... selectors) {
        return new CssStyle(selectors);
    }

    default CssSelector select(String selector, KeyValuePair<String>... rules) {
        return new CssSelector(selector, rules);
    }

    default KeyValuePair<String> property(CssProperty key, String value) {
        return new KeyValuePair<>(key.toString(), value);
    }

    default KeyValuePair<String> property(String key, String value) {
        return new KeyValuePair<>(key, value);
    }

    default Style external(String path) {
        return new ExternalStyle(path);
    }

    default Style bundle(Style... styles) {
        return new BundleStyle(styles);
    }
}
