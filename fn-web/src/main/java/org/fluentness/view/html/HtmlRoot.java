package org.fluentness.view.html;

import org.fluentness.view.RootWebView;

public class HtmlRoot extends Html implements RootWebView {

    public HtmlRoot(CharSequence[] html) {
        super("html", html);
    }

    @Override
    public String toString() {
        return "<!DOCTYPE html><" + tag + attributes + ">" + inner + "</" + tag + ">";
    }
}
