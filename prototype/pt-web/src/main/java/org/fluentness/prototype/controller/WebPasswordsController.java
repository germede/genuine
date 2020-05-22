package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.prototype.view.WebView;

public class WebPasswordsController extends AbstractWebController<WebView> {

    @BasePath("/calendar")
    public WebPasswordsController(WebView web) {
        super(web);
    }


}