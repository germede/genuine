package org.fluentness.view;

import org.fluentness.common.namedValues.NamedValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarkupAttributes implements View {

    private final List<NamedValue> attributes;

    public MarkupAttributes(NamedValue... attributes) {
        this.attributes = new ArrayList<>(Arrays.asList(attributes));
    }

    @Override
    public String render() {
        return attributes.stream()
                .map(attribute -> {
                    Object value = attribute.value();
                    return " " + attribute.name() + (value != null ? ("=\"" + value + "\"") : "");
                })
                .collect(Collectors.joining());
    }

    public void add(NamedValue attribute) {
        attributes.add(attribute);
    }

    @Override
    public String toString() {
        return render();
    }
}
