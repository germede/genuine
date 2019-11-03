package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.router.HttpMethod;
import org.fluentness.service.router.HttpStatusCode;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

public class AbstractWebControllerTest {

    private AbstractWebController webController;

    @Before
    public void setUp() {
        webController = new AbstractWebController(){
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
        };
    }

    @Test
    public void getActions_sizeIsCalled_numberOfActionsIsCorrect() {
        assertEquals(9, webController.getActions().size());
    }

    @Test
    public void getActions_descriptorsAreSet_descriptorsCanBeRetrieved() throws NoSuchMethodException {

        for (WebAction webAction : webController.getActions()) {
            if (webAction.getMethod().equals(webController.getClass().getMethod("testVoid"))) {
                assertEquals(HttpMethod.GET, webAction.getHttpMethod());
                assertEquals("/void", webAction.getPath());
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("testPostParameter", String.class))) {
                assertEquals(HttpMethod.POST, webAction.getHttpMethod());
                assertEquals("/testPostParameter", webAction.getPath());
            }
        }
    }

    @Test
    public void getActions_actionsAreGiven_actionsAreFound() throws NoSuchMethodException {

        Controller.Action testVoid = null;
        Controller.Action testPostParameter = null;
        Controller.Action testServerError = null;
        Controller.Action notAnActionBecauseNoActionAnnotation = null;
        for (WebAction webAction : webController.getActions()) {
            if (webAction.getMethod().equals(webController.getClass().getMethod("testVoid"))) {
                testVoid = webAction;
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("testPostParameter", String.class))) {
                testPostParameter = webAction;
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("testServerError"))) {
                testServerError = webAction;
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("notAnActionBecauseNoActionAnnotation"))) {
                notAnActionBecauseNoActionAnnotation = webAction;
            }
        }
        assertNotNull(testVoid);
        assertNotNull(testPostParameter);
        assertNotNull(testServerError);
        assertNull(notAnActionBecauseNoActionAnnotation);
    }
}
