package org.fluentness.controller.web.template.html;

import org.fluentness.controller.web.template.WebTemplate;

public class HtmlTemplate extends Html implements WebTemplate {

    // using xhtml
    public HtmlTemplate(CharSequence... html) {
        super("html", html);
    }

    @Override
    public String toString() {
        return
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            super.toString();
    }
}
