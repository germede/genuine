package org.fluentness.flow.component.style;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CssStyle extends Style {

    private CssSelector[] selectors;

    CssStyle(CssSelector[] selectors) {
        this.selectors = selectors;
    }

    private void compileInnerSelectors(CssSelector selector, List<CssSelector> result) {
//        for (KeyValuePairImpl<String> rule : selector.rules) {
//                CssSelector inner = rule;
//                inner.selector = String.format("%s %s", selector.selector, inner.selector);
//                result.add(inner);
//                compileInnerSelectors(inner, result);
//
//        }
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
