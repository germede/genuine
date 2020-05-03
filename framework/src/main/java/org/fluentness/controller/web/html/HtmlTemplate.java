package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebTemplate;

public class HtmlTemplate extends Html implements WebTemplate {

    public HtmlTemplate(CharSequence[] html) {
        super("html", html);
    }

    @Override
    public String toString() {
        return "<!DOCTYPE html><" + tag + attributes + ">" + inner + "</" + tag + ">";
    }
}
