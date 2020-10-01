//package org.fluentness.prototype.controller;
//
//import org.fluentness.prototype.view.WebView;
//import org.fluentness.controller.AbstractWebController;
//import org.fluentness.service.dispatcher.ActionDispatcher;
//import org.fluentness.service.mail.CheckingEmails;
//import org.fluentness.view.container.HtmlContainer;
//
//import static org.fluentness.view.AbstractWebView.form;
//import static org.fluentness.view.AbstractWebView.input;
//import static org.fluentness.view.component.HtmlAttribute.*;
//
//public class WebEmailController extends AbstractWebController {
//
//    public WebEmailController(WebView web, ActionDispatcher dispatcher) {
//        super(web, dispatcher);
//    }
//
//    @Action(path = "/email")
//    HtmlContainer email() {
//        return form(ACTION + "/email/inbox", METHOD + "GET",
//            input(NAME + "email", TYPE + "email"),
//            input(NAME + "password", TYPE + "password"),
//            input(TYPE + "submit")
//        );
//    }
//
//    @Action(path = "/inbox")
//    String inbox(String email, String password) {
//        String check = new CheckingEmails().check(email, password);
//        System.out.println(check);
//        return check;
//    }
//}