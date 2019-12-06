package org.fluentness.controller.web;

import org.junit.Before;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractWebControllerTest {

    private AbstractWebController<AbstractWeb> webController;

    @Before
    public void setUp() {
        webController = new AbstractWebController<AbstractWeb>(AbstractWeb.class){


            public void notAnActionBecauseNoActionAnnotation() {
            }

            void notAnActionBecauseItIsNotPublic() {
            }

            public void testVoid() {
                int result = 2 + 2;
            }

            public String testString() {
                return "Hello world!";
            }

            public int testForbidden() {
                return 403;
            }

            public int testServerError() {
                int outOfBounds = new int[]{}[1];
                return 200;
            }

            public void testResponse(HttpServletResponse response) throws IOException {
                response.setStatus(404);
                response.getWriter().println("Not found");
            }

            public WebView testView() {
                return new WebView() {
                    @Override
                    public String render() {
                        return "Test web view";
                    }
                };
            }

            public String testGetParameter(String name) {
                return "Greetings, " + name;
            }

            public String testPostParameter(String name) {
                return "Greetings, " + name;
            }
        };
    }

//    @Test
//    public void getActions_sizeIsCalled_numberOfActionsIsCorrect() {
//        assertEquals(9, webController.getActions().size());
//    }
//
//    @Test
//    public void getActions_descriptorsAreSet_descriptorsCanBeRetrieved() throws NoSuchMethodException {
//
//        List<AbstractWebController.Action> actions = webController.getActions();
//        for (AbstractWebController.Action action : actions) {
//            if (action.getMethod().equals(webController.getClass().getMethod("testVoid"))) {
//                assertEquals("GET", action.getHttpMethods());
//                assertEquals("/void", action.getPath());
//            } else if (action.getMethod().equals(webController.getClass().getMethod("testPostParameter", String.class))) {
//                assertEquals("POST", action.getHttpMethods());
//                assertEquals("/testPostParameter", action.getPath());
//            }
//        }
//    }
//
//    @Test
//    public void getActions_actionsAreGiven_actionsAreFound() throws NoSuchMethodException {
//
//        AbstractWebController.Action testVoid = null;
//        AbstractWebController.Action testPostParameter = null;
//        AbstractWebController.Action testServerError = null;
//        AbstractWebController.Action notAnActionBecauseNoActionAnnotation = null;
//        List<AbstractWebController.Action> actions = webController.getActions();
//        for (AbstractWebController.Action action : actions) {
//            if (action.getMethod().equals(webController.getClass().getMethod("testVoid"))) {
//                testVoid = action;
//            } else if (action.getMethod().equals(webController.getClass().getMethod("testPostParameter", String.class))) {
//                testPostParameter = action;
//            } else if (action.getMethod().equals(webController.getClass().getMethod("testServerError"))) {
//                testServerError = action;
//            } else if (action.getMethod().equals(webController.getClass().getMethod("notAnActionBecauseNoActionAnnotation"))) {
//                notAnActionBecauseNoActionAnnotation = action;
//            }
//        }
//        assertNotNull(testVoid);
//        assertNotNull(testPostParameter);
//        assertNotNull(testServerError);
//        assertNull(notAnActionBecauseNoActionAnnotation);
//    }
}
