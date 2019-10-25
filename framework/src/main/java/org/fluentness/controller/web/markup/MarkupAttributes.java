package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MarkupAttributes extends WebView {

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
