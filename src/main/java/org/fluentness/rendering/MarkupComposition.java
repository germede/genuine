package org.fluentness.rendering;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MarkupComposition implements Renderable {

    private MarkupElement[] elements;

    public MarkupComposition(MarkupElement... elements) {
        this.elements = elements;
    }

    @Override
    public String render() {
        return Arrays.stream(elements).map(MarkupElement::render).collect(Collectors.joining());
    }

}
