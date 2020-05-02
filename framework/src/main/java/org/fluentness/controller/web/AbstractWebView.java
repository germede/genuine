package org.fluentness.controller.web;

import org.fluentness.controller.web.template.WebTemplate;

public abstract class AbstractWebView<C extends AbstractWebController> {

    protected C controller;

    final void setController(C controller) {
        this.controller = controller;
    }

    public abstract WebTemplate getTemplate(CharSequence actionResult);
}
