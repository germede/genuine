package org.fluentness.rendering;

import org.fluentness.common.NamedValue;

import java.util.Arrays;
import java.util.stream.Collectors;

class MarkupAttributes implements Renderable {

    private final NamedValue[] attributes;

    MarkupAttributes(NamedValue[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String render() {
        return " " + Arrays.stream(attributes).collect(Collectors.joining(" "));
    }
}
