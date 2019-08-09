package org.fluentness.flow.view;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MarkupAttributes extends View {

    private List<String> attributes;

    public MarkupAttributes(String... attributes) {
        this.attributes = new LinkedList<>();
        Arrays.stream(attributes).forEach(this::add);
    }

    public void add(String attribute) {
        attributes.add(attribute + "\"");
    }

    @Override
    public String render() {
        return String.join(" ", attributes);
    }

}
