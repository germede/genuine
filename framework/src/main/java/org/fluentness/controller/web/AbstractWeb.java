package org.fluentness.controller.web;

import org.fluentness.controller.web.style.WebStyle;

public abstract class AbstractWeb<C extends AbstractWebController> {

    protected C controller;

    void setController(C controller) {
        this.controller = controller;
    }

    public abstract WebStyle style();

    public abstract WebView view(WebView toInclude);
}
