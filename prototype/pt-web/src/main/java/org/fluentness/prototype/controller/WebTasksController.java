package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.prototype.view.WebView;

public class WebTasksController extends AbstractWebController<WebView> {

    @BasePath("/calendar")
    public WebTasksController(WebView web) {
        super(web);
    }

}