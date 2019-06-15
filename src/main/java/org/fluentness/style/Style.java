package org.fluentness.style;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.onion.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Style implements Component {

    private final Selector[] selectors;

    Style(Selector... selectors) {
        this.selectors = selectors;
    }

    @Override
    public String toString() {
        List<Selector> selectors = new ArrayList<>(Arrays.asList(this.selectors));
        Arrays.stream(this.selectors).forEach(selector -> compileInnerSelectors(selector, selectors));

        StringBuilder result = new StringBuilder();
        selectors.forEach(selector -> result.append(selector.toString()));

        return result.toString().replaceAll("\\s+","");
    }

    private void compileInnerSelectors(Selector selector, List<Selector> result) {
        for (KeyValuePair<String> rule : selector.rules) {
            if (rule instanceof Selector) {
                Selector inner = (Selector) rule;
                inner.selector = String.format("%s %s", selector.selector, inner.selector);
                result.add(inner);
                compileInnerSelectors(inner, result);
            }
        }
    }

}
