package org.fluentness.form;


import org.fluentness.common.NamedValue;
import org.fluentness.rendering.HtmlFunctions;
import org.fluentness.rendering.MarkupFunctions;
import org.fluentness.rendering.Renderable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Field implements Renderable, HtmlFunctions, MarkupFunctions {

    private List<NamedValue<String>> attributes = new ArrayList();

    Field(String type, NamedValue<String>[] attributes) {
        this.attributes.add(TYPE -> type);
        this.attributes.addAll(Arrays.asList(attributes));
    }

    void setName(String name) {
        this.attributes.add(NAME -> name);
    }

    @Override
    public String render() {
        return input(
                attributes.toArray(new NamedValue[0])
        ).render();
    }
}
