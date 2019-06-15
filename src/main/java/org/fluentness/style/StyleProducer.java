package org.fluentness.style;

import org.fluentness.base.generics.Producer;
import org.fluentness.base.lambdas.KeyValuePair;

public abstract class StyleProducer implements Producer<Style> {

    @Override
    public Class<Style> getProducedComponentType() {
        return Style.class;
    }

    protected Style css(Selector... selectors) {
        return new Style(selectors);
    }

    protected Selector select(String selector, KeyValuePair<String>... rules) {
        return new Selector(selector, rules);
    }

}
