package org.fluentness.controller.web;

import org.fluentness.style.web.WebStyle;
import org.fluentness.view.web.HtmlView;

public abstract class WebViewProvider<C extends AbstractWebController> {

    protected final C controller;

    public WebViewProvider(C controller) {
        this.controller = controller;
    }

    public abstract WebStyle getStyle();

    public abstract HtmlView getView(HtmlView toInclude);
}
