package org.fluentness.controller.web;

import org.fluentness.controller.web.html.Html;
import org.fluentness.controller.web.html.HtmlStyler;

public abstract class AbstractWeb<C extends AbstractWebController> {

    protected C webController;

    void setController(C webController) {
        this.webController = webController;
    }

    protected abstract void setStyles(HtmlStyler styler);

    protected abstract Html main(Html... toInclude);
}
