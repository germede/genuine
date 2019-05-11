package org.fluentness.rendering;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MarkupComposition implements Renderable {

    private MarkupEmptyElement[] elements;

    public MarkupComposition(MarkupEmptyElement... elements) {
        this.elements = elements;
    }

    @Override
    public String render() {
        return Arrays.stream(elements).map(MarkupEmptyElement::render).collect(Collectors.joining());
    }

}
