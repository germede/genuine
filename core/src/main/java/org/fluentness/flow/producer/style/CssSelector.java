package org.fluentness.flow.producer.style;

import org.fluentness.base.common.lambda.KeyValuePair;

import java.util.Arrays;

public class CssSelector {

    String selector;
    KeyValuePair<String>[] rules;

    CssSelector(String selector, KeyValuePair<String>... rules) {
        this.selector = selector;
        this.rules = rules;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(selector + " {");
        Arrays.stream(rules)
                .filter(rule -> !(rule instanceof CssSelector))
                .forEach(rule -> result
                        .append("\n    ")
                        .append(rule.getKey().replaceAll("_","-"))
                        .append(": ")
                        .append(rule.getValue())
                        .append(";")
                );
        result.append("\n}\n\n");
        return result.toString();
    }
}
