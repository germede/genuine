package org.fluentness.prototype.controller;

import org.fluentness.prototype.view.WebView;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.dispatcher.DynamicDispatcher;

import static org.fluentness.prototype.service.Localization.*;

public class WebController extends AbstractWebController<WebView> {

    public WebController(WebView webView, DynamicDispatcher dispatcher) {
        super(webView, dispatcher);
    }

    @Action(path = "/")
    String index() {
        return _welcome_message.toString();
    }

    @Action(path = "/404")
    String notFound() {
        return _page_not_found.toString();
    }

    @Action(path = "/500")
    String serverError() {
        return _server_error.toString();
    }

}