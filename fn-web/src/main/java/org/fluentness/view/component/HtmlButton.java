package org.fluentness.view.component;

import org.fluentness.controller.event.JavaScriptCommand;
import org.fluentness.view.container.HtmlContainer;

public class HtmlButton extends HtmlContainer implements Button {

    private final CharSequence text;

    public HtmlButton(CharSequence text) {
        super("button", text);
        this.text = text;
    }

    @Override
    public CharSequence getText() {
        return text;
    }

    @Override
    public void setText(CharSequence text) {
        JavaScriptCommand.addCommand(JavaScriptCommand.CHANGE_INNER, getId(), text);
    }
}
