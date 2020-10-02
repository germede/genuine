package org.fluentness.view.component.text;

public class HtmlText extends BaseHtmlText implements Text {

    public HtmlText(CharSequence text) {
        super("p", text);
    }

}
