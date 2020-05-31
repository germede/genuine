package org.fluentness.view.component.text;

public class HtmlButton extends AbstractHtmlText implements Button {

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
