package org.fluentness.prototype.controller;

import org.fluentness.controller.action.AbstractActionWebController;
import org.fluentness.prototype.view.WebView;

import static org.fluentness.prototype.service.Localization.*;

public class WebActionController extends AbstractActionWebController<WebView> {

    public WebActionController() {
        super("/action");
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