package org.fluentness.view.component.text;

import org.fluentness.view.component.text.form.Button;
import org.fluentness.view.event.Handler;

public class HtmlButton extends BaseHtmlText implements Button {

    private final Type type;

    public HtmlButton(Type type, CharSequence text) {
        super("button", text);
        this.type = type;
        withAttribute("class", type.name().toLowerCase());
        if (type.equals(Type.DISABLED)) {
            withAttribute("disabled", null);
        }
    }

    @Override
    public Type getType() {
        return type;
    }

}
