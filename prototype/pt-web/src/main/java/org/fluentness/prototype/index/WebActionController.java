package org.fluentness.prototype.index;

import org.fluentness.controller.action.AbstractWebActionController;

import static org.fluentness.prototype.common.Localization.*;

public class WebActionController extends AbstractWebActionController {

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