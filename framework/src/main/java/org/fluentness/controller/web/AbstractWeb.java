package org.fluentness.controller.web;

import org.fluentness.controller.web.style.WebStyle;

public abstract class AbstractWeb<C extends AbstractWebController> {

    protected final C controller;

    public AbstractWeb(C controller) {
        this.controller = controller;
    }

    public abstract WebStyle getStyle();

    public abstract WebView getView(WebView toInclude);
}
