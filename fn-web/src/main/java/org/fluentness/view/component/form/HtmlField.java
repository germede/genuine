package org.fluentness.view.component.form;

import org.fluentness.view.component.HtmlContainer;

public class HtmlField extends HtmlContainer implements Field {

    public HtmlField(String name, Type type, CharSequence placeholder, boolean required) {
        super("input");
        withAttribute("name", name);
        withAttribute("type", type.toString().toLowerCase());
        withAttribute("placeholder", placeholder);
        if (required) withAttribute("required");
    }

}
