package org.fluentness.style;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.generics.Provider;

public interface StyleProvider extends Provider<Style> {

    default Style css(Style.Selector... selectors) {
        return new Style(selectors);
    }

    default Style.Selector select(String selector, KeyValuePair<String>... rules) {
        return new Style.Selector(selector, rules);
    }

}
