package com.sample.controller;

import com.sample.view.WebView;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.view.html.Html;

import static org.fluentness.view.AbstractWebView.form;
import static org.fluentness.view.AbstractWebView.input;
import static org.fluentness.view.html.HtmlAttribute.*;

public class WebEmailController extends AbstractWebController {

    @BasePath("/email")
    public WebEmailController(WebView web) {
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