package org.fluentness.style;

import org.fluentness.common.lambdas.NamedValue;
import org.fluentness.common.Provider;

public interface StyleProvider extends Provider<Style> {

    default Style css(Style.Selector... selectors) {
        return new Style(selectors);
    }

    default Style.Selector select(String selector, NamedValue<String>... rules) {
        return new Style.Selector(selector, rules);
    }

}
