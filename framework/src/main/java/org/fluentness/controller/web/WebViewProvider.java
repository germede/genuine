package org.fluentness.controller.web;

import org.fluentness.controller.web.view.html.style.WebStyle;
import org.fluentness.controller.web.view.html.Html;

public abstract class WebViewProvider<C extends Controller> {

    protected final C controller;

    public WebViewProvider(C controller) {
        this.controller = controller;
    }

    public abstract WebStyle getStyle();

    public abstract Html getView(Html toInclude);
}
