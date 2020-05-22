package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.prototype.view.WebView;

public class WebFilesController extends AbstractWebController<WebView> {

    @BasePath("/calendar")
    public WebFilesController(WebView web) {
        super(web);
    }


}