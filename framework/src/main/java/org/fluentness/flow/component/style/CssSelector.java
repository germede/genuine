package org.fluentness.flow.component.style;

import org.fluentness.base.common.lambda.KeyValuePair;

import java.util.Arrays;

public class CssSelector {

    private String selector;
    private KeyValuePair<String>[] rules;

    CssSelector(String selector, String... rules) {
        this.selector = selector;
        this.rules = rules;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(selector + " {");
        Arrays.stream(rules)
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
