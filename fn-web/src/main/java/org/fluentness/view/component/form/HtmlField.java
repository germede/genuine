package org.fluentness.view.component.form;

import org.fluentness.view.component.HtmlContainer;

public class HtmlField extends HtmlContainer implements Field {

    private final String name;
    private final Type type;
    private final CharSequence label;

    public HtmlField(String name, Type type, CharSequence label) {
        super("input");
        withAttribute("name", name);
        withAttribute("type", type.toString().toLowerCase());
        this.name = name;
        this.type = type;
        this.label = label;
    }

}
