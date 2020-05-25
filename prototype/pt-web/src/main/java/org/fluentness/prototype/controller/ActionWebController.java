package org.fluentness.prototype.controller;

import org.fluentness.controller.action.AbstractActionWebController;

import static org.fluentness.prototype.service.Localization.*;

public class ActionWebController extends AbstractActionWebController {

    public ActionWebController() {
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