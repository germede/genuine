package org.fluentness.flow.component.style;

import org.fluentness.base.common.lambda.KeyValuePairImpl;

public interface StyleFactory {

    default Style css(CssSelector... selectors) {
        return new CssStyle(selectors);
    }

    default CssSelector select(String selector, KeyValuePairImpl<String>... rules) {
        return new CssSelector(selector, rules);
    }

    default KeyValuePairImpl<String> property(CssProperty key, String value) {
        return new KeyValuePairImpl<>(key.toString(), value);
    }

    default KeyValuePairImpl<String> property(String key, String value) {
        return new KeyValuePairImpl<>(key, value);
    }

    default Style external(String path) {
        return new ExternalStyle(path);
    }

    default Style bundle(Style... styles) {
        return new BundleStyle(styles);
    }
}
