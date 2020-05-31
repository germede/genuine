package org.fluentness.view.component.text;

public class HtmlText extends AbstractHtmlText implements Text {

    public HtmlText(CharSequence text) {
        super("p", text);
    }

}
