package org.fluentness.controller.web.template.html;

import org.fluentness.controller.web.template.WebTemplate;

public class HtmlTemplate extends Html implements WebTemplate {

    public HtmlTemplate(CharSequence... html) {
        super("html", html);
    }
}
