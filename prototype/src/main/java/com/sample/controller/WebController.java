package com.sample.controller;

import com.sample.view.WebView;
import org.fluentness.controller.AbstractWebController;

import static com.sample.service.Translation.*;

public class WebController extends AbstractWebController<WebView> {

    @BasePath("/")
    public WebController(WebView webView) {
        super(webView);
    }

    @Action
    String index() {
        return _welcome_message;
    }

    @Action(path = "404")
    String notFound() {
        return _page_not_found;
    }

    @Action(path = "500")
    String serverError() {
        return _server_error;
    }

}