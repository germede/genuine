package org.fluentness.rendering;

import org.fluentness.common.NamedValue;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MarkupAttributes implements Renderable {

    private final NamedValue[] attributes;

    public MarkupAttributes(NamedValue... attributes) {
        this.attributes = attributes;
    }

    @Override
    public String render() {
        return " " + Arrays.stream(attributes)
                .map(attribute -> attribute.name() + "=\"" + attribute.value() + "\"")
                .collect(Collectors.joining(" "));
    }
}
