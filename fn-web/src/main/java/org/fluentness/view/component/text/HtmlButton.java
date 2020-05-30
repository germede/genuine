package org.fluentness.view.component.text;

import org.fluentness.controller.view.JavaScriptCommand;
import org.fluentness.view.component.HtmlContainer;

public class HtmlButton extends HtmlContainer implements Button {

    private final CharSequence text;

    public HtmlButton(CharSequence text) {
        super("button");
        withInner(text);
        this.text = text;
    }

    @Override
    public CharSequence getText() {
        return text;
    }

    @Override
    public void setText(CharSequence text) {
        JavaScriptCommand.changeInner(getXpath(), text);
    }
}
