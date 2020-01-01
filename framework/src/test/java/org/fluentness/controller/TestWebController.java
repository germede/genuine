package org.fluentness.controller;

import org.fluentness.controller.web.Controller;
import org.fluentness.service.server.Request;

public class TestWebController extends Controller<TestWebViewProvider> {

    public TestWebController() {
        super(TestWebViewProvider.class);
    }

    @Action(path = "/")
    public String index(Request request) {
        return "OK";
    }


}