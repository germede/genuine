package org.fluentness.prototype.controller;

import org.fluentness.controller.WebController;

import static org.fluentness.prototype.service.Translator.*;

public class WebActionController extends WebController {

    public WebActionController() {
        super(null, "/action");
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