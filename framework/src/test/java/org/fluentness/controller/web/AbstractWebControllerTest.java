package org.fluentness.controller.web;

import org.fluentness.controller.web.style.WebStyle;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractWebControllerTest {

    private AbstractWebController<AbstractWeb> webController;

    @Before
    public void setUp() {
        webController = new AbstractWebController<AbstractWeb>(new AbstractWeb() {
            @Override
            public WebStyle style() {
                return null;
            }

            @Override
            public WebView view(WebView toInclude) {
                return null;
            }
        }){

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

            @Action(path = "/testPostParameter", method = "POST")
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

        List<WebAction> actions = webController.getActions();
        for (WebAction webAction : actions) {
            if (webAction.getMethod().equals(webController.getClass().getMethod("testVoid"))) {
                assertEquals("GET", webAction.getHttpMethod());
                assertEquals("/void", webAction.getPath());
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("testPostParameter", String.class))) {
                assertEquals("POST", webAction.getHttpMethod());
                assertEquals("/testPostParameter", webAction.getPath());
            }
        }
    }

    @Test
    public void getActions_actionsAreGiven_actionsAreFound() throws NoSuchMethodException {

        WebAction testVoid = null;
        WebAction testPostParameter = null;
        WebAction testServerError = null;
        WebAction notAnActionBecauseNoActionAnnotation = null;
        List<WebAction> actions = webController.getActions();
        for (WebAction webAction : actions) {
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
