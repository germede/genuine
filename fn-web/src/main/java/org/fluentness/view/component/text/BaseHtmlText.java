package org.fluentness.view.component.text;

import org.fluentness.controller.JavaScriptCommand;
import org.fluentness.view.component.HtmlContainer;

public abstract class BaseHtmlText extends HtmlContainer implements Text {

    private final CharSequence text;

    public BaseHtmlText(String tag, CharSequence text) {
        super(tag);
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
