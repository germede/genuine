package org.fluentness.style;

import org.fluentness.base.lambdas.KeyValuePair;

import java.util.Arrays;

public class Selector implements KeyValuePair<String> {

    String selector;
    KeyValuePair<String>[] rules;

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
