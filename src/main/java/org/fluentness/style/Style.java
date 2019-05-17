package org.fluentness.style;

import org.fluentness.common.NamedValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Style {

    Selectors getSelectors();

    default Selectors selectors(Selector... selectors) {
        return new Selectors(selectors);
    }

    default Selector selector(String selector, NamedValue<String>... rules) {
        return new Selector(selector, rules);
    }

    class Selectors {

        private final Selector[] selectors;

        private Selectors(Selector... selectors) {
            this.selectors = selectors;
        }

        @Override
        public String toString() {
            List<Selector> result = new ArrayList<>(Arrays.asList(this.selectors));
            Arrays.stream(selectors).forEach(selector -> compileInnerSelectors(selector, result));
            return result.stream().map(Selector::toString).collect(Collectors.joining());
        }

        private void compileInnerSelectors(Selector selector, List<Selector> result) {
            for (NamedValue<String> rule : selector.rules) {
                if (rule instanceof Selector) {
                    Selector inner = (Selector) rule;
                    inner.selector = String.format("%s %s", selector.selector, inner.selector);
                    result.add(inner);
                    compileInnerSelectors(inner, result);
                }
            }
        }
    }

    class Selector implements NamedValue<String> {

        private String selector;
        private NamedValue<String>[] rules;

        private Selector(String selector, NamedValue<String>... rules) {
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
                            .append(rule.name())
                            .append(": ")
                            .append(rule.value())
                            .append(";")
                    );
            result.append("\n}\n\n");
            return result.toString();
        }
    }
}
