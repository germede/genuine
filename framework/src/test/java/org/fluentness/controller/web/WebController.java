package org.fluentness.controller.web;

public class WebController extends AbstractWebController {

    @Action(path = "/void")
    public void testVoid() {
        int result = 2 + 2;
    }

    @Action(path = "/string")
    public String testString() {
        return "Hello world!";
    }

    @Action(path = "/testForbidden")
    public int testForbidden() {
        return 403;
    }

    @Action(path = "/testServerError")
    public int testServerError() {
        int outOfBounds = new int[]{}[1];
        return 200;
    }

    @Action(path = "/testResponse")
    public Response testResponse() {
        return response -> {
            response.setStatus(404);
            response.getWriter().println("Not found");
        };
    }

    @Action(path = "/testView")
    public WebView testView() {
        return new WebView() {
            @Override
            public String render() {
                return "Test web view";
            }
        };
    }

    @Action(path = "/testGetParameter", method = "GET")
    public String testGetParameter(String name) {
        return "Greetings, " + name;
    }

}