package org.fluentness.controller.web;

import org.fluentness.controller.web.view.WebView;
import org.fluentness.controller.web.view.html.style.WebStyle;

public abstract class AbstractWeb<C extends AbstractWebController> {

    protected C controller;

    void setController(C controller) {
        this.controller = controller;
    }

    public abstract WebStyle getStyle();

    public abstract WebView getView(WebView toInclude);
}
