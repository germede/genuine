package com.sample.controller;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;

import static com.sample.service.Translator._welcome_message;
import static org.fluentness.controller.web.template.html.HtmlFactory.h1;

public class WebController extends AbstractWebController {

    public WebController() {
        super(WebView.class);
    }

    @Action(path = "/")
    Html index() {
        return h1(_welcome_message);
    }

}