package org.fluentness.view;

import org.fluentness.common.lambdas.KeyValuePair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MarkupAttributes extends View {

    private List<KeyValuePair<String>> attributes;

    public MarkupAttributes(KeyValuePair<String>... attributes) {
        this.attributes = new LinkedList<>();
        this.attributes.addAll(Arrays.asList(attributes));
    }

    public void add(KeyValuePair<String> attribute) {
        attributes.add(attribute);
    }

    @Override
    public String render() {
        return attributes.stream()
            .map(attribute -> " " + attribute.getKey().toLowerCase() +
                (attribute.getValue() != null ? ("=\"" + attribute.getValue() + "\"") : ""))
            .collect(Collectors.joining());
    }

    @Override
    View setTemplate(View view) {
        return this;
    }
}
