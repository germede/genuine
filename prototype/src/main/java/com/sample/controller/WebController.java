package com.sample.controller;

import com.sample.view.WebView;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.view.Html;

import static com.sample.service.Translation.*;
import static org.fluentness.view.HtmlFactory.h1;

public class WebController extends AbstractWebController {

    @BasePath("/")
    public WebController() {
        super(WebView.class);
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