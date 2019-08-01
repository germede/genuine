package org.fluentness.flow.component.view;

import org.fluentness.base.common.lambda.KeyValuePairLambda;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MarkupAttributes extends View {

    private List<KeyValuePairLambda<String>> attributes;

    public MarkupAttributes(KeyValuePairLambda<String>... attributes) {
        this.attributes = new LinkedList<>();
        this.attributes.addAll(Arrays.asList(attributes));
    }

    public void add(KeyValuePairLambda<String> attribute) {
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
