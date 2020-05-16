package com.sample.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.controller.html.Html;

import static org.fluentness.controller.AbstractWeb.form;
import static org.fluentness.controller.AbstractWeb.input;
import static org.fluentness.controller.html.HtmlAttribute.*;

public class WebEmailController extends AbstractWebController {

    @BasePath("/email")
    public WebEmailController(Web web) {
        super(web);
    }

    @Action
    Html email() {
        return form(ACTION + "/email/inbox", METHOD + "GET",
            input(NAME + "email", TYPE + "email"),
            input(NAME + "password", TYPE + "password"),
            input(TYPE + "submit")
        );
    }

    @Action
    String inbox(String email, String password) {
        String check = new CheckingEmails().check(email, password);
        System.out.println(check);
        return check;
    }
}