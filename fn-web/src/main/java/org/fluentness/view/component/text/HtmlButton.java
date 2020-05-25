package org.fluentness.view.component.text;

import org.fluentness.controller.event.JavaScriptCommand;
import org.fluentness.view.component.container.HtmlContainer;

public class HtmlButton extends HtmlContainer implements Button {

    private final CharSequence text;

    public HtmlButton(CharSequence text) {
        super("button");
        inner.append(text);
        this.text = text;
    }

    @Override
    public CharSequence getText() {
        return text;
    }

    @Override
    public void setText(CharSequence text) {
        JavaScriptCommand.changeInner(getId(), text);
    }
}
