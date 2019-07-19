package org.fluentness.flow.view;

import org.fluentness.base.lambdas.KeyValuePair;

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

}
