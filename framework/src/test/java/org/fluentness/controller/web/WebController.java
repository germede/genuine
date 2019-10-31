package org.fluentness.controller.web;

import org.fluentness.service.server.HttpMethod;
import org.fluentness.service.server.HttpStatusCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebController extends AbstractWebController {

    public void notAnActionBecauseNoActionAnnotation() {
    }

    @Action(path = "/notAnActionBecauseItIsNotPublic")
    void notAnActionBecauseItIsNotPublic() {
    }

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

    @Action(path = "/testHttpStatusCode")
    public HttpStatusCode testHttpStatusCode() {
        return HttpStatusCode.FORBIDDEN;
    }

    @Action(path = "/testServerError")
    public int testServerError() {
        int outOfBounds = new int[]{}[1];
        return 200;
    }

    @Action(path = "/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.setStatus(404);
        response.getWriter().println("Not found");
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

    @Action(path = "/testGetParameter")
    public String testGetParameter(String name) {
        return "Greetings, " + name;
    }

    @Action(path = "/testPostParameter", method = HttpMethod.POST)
    public String testPostParameter(String name) {
        return "Greetings, " + name;
    }

}