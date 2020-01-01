package org.fluentness.controller.web;

import org.fluentness.controller.web.view.WebRenderable;
import org.fluentness.controller.web.view.html.style.WebStyle;

public abstract class View<C extends Controller> {

    protected C controller;

    void setController(C controller) {
        this.controller = controller;
    }

    protected abstract WebStyle getStyle();

    protected abstract WebRenderable getView(WebRenderable toInclude);
}
