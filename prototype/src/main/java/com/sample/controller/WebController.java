package com.sample.controller;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.html.Html;

import static com.sample.Translations.*;
import static org.fluentness.controller.web.html.HtmlFactory.h1;

public class WebController extends AbstractWebController {

    @BasePath("/")
    public WebController() {
        super(Web.class);
    }

    @Action
    Html index() {
        return h1(_welcome_message);
    }

    @Action(path = "404")
    Html notFound() {
        return h1(_page_not_found);
    }

    @Action(path = "500")
    Html serverError() {
        return h1(_server_error);
    }

}