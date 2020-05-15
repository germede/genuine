package com.sample.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.translator.Translator;

import static com.sample.service.StringTranslator.*;

public class WebController extends AbstractWebController<Web> {

    @BasePath("/")
    public WebController(Web web, Translator translator) {
        super(web);
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