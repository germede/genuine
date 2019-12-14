package org.fluentness.controller;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.service.server.Request;

public class TestWebController extends AbstractWebController<TestWeb> {

    public TestWebController() {
        super(TestWeb.class);
    }

    @Action(path = "/")
    public String index(Request request) {
        return "OK";
    }


}