package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.prototype.view.WebView;

public class WebContactsController extends AbstractWebController<WebView> {

    @BasePath("/calendar")
    public WebContactsController(WebView web) {
        super(web);
    }


}