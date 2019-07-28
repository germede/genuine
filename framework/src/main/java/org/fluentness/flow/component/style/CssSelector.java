package org.fluentness.flow.component.style;

import org.fluentness.base.common.lambda.KeyValuePairImpl;

import java.util.Arrays;

public class CssSelector {

    String selector;
    KeyValuePairImpl<String>[] rules;

    CssSelector(String selector, KeyValuePairImpl<String>... rules) {
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
