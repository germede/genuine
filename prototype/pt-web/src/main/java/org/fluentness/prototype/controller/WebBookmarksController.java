package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.prototype.view.WebView;

public class WebBookmarksController extends AbstractWebController<WebView> {

    @BasePath("/calendar")
    public WebBookmarksController(WebView web) {
        super(web);
    }


}