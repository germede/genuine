package org.fluentness.controller.html;

import org.fluentness.controller.WebView;

public class HtmlRoot extends Html implements WebView {

    public HtmlRoot(CharSequence[] html) {
        super("html", html);
    }

    @Override
    public String toString() {
        return "<!DOCTYPE html><" + tag + attributes + ">" + inner + "</" + tag + ">";
    }
}
