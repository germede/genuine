package org.fluentness.flow.style;

import org.fluentness.base.lambdas.KeyValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CssStyle extends Style {

    private CssSelector[] selectors;

    CssStyle(CssSelector[] selectors) {
        this.selectors = selectors;
    }

    private void compileInnerSelectors(CssSelector selector, List<CssSelector> result) {
        for (KeyValuePair<String> rule : selector.rules) {
            if (rule instanceof CssSelector) {
                CssSelector inner = (CssSelector) rule;
                inner.selector = String.format("%s %s", selector.selector, inner.selector);
                result.add(inner);
                compileInnerSelectors(inner, result);
            }
        }
    }

    @Override
    public String render() {

        List<CssSelector> selectors = new ArrayList<>(Arrays.asList(this.selectors));
        Arrays.stream(this.selectors).forEach(selector -> compileInnerSelectors(selector, selectors));

        StringBuilder result = new StringBuilder();
        selectors.forEach(selector -> result.append(selector.toString()));


        // todo minify
        return result.toString();
    }
}
