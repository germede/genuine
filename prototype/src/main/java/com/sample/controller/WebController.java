package com.sample.controller;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.template.html.HtmlFactory.h1;

public class WebController extends AbstractWebController {

    public WebController() {
        super(WebView.class);
    }

    @Action(path = "/")
    Html index() {
        return h1(_welcome_message);
    }

    @Action(path = "/404")
    Html notFound() {
        return h1(_page_not_found);
    }

    @Action(path = "/500")
    Html serverError() {
        return h1(_server_error);
    }

}