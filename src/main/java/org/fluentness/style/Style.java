package org.fluentness.style;

import org.fluentness.base.lambdas.KeyValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Style {

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

    public static class Selector implements KeyValuePair<String> {

        private String selector;
        private KeyValuePair<String>[] rules;

        Selector(String selector, KeyValuePair<String>... rules) {
            this.selector = selector;
            this.rules = rules;
        }

        @Override
        public String apply(String s) {
            return null;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder(selector + " {");
            Arrays.stream(rules)
                    .filter(rule -> !(rule instanceof Selector))
                    .forEach(rule -> result
                            .append("\n    ")
                            .append(rule.key().replaceAll("_","-"))
                            .append(": ")
                            .append(rule.value())
                            .append(";")
                    );
            result.append("\n}\n\n");
            return result.toString();
        }
    }
}
