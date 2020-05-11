package org.fluentness.controller.html;

import org.fluentness.controller.RootWebView;

public class HtmlRoot extends Html implements RootWebView {

    public HtmlRoot(CharSequence[] html) {
        super("html", html);
    }

    @Override
    public String toString() {
        return "<!DOCTYPE html><" + tag + attributes + ">" + inner + "</" + tag + ">";
    }
}
