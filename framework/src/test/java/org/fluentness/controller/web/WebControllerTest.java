package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.HttpMethod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class WebControllerTest {

    private WebController webController;

    @Before
    public void setUp() {
        webController = new WebController();
    }

    @Test
    public void getActions_numberOfActionsIsCorrect() {
        Assert.assertEquals(9, webController.getActions().size());
    }

    @Test
    public void getActions_actionDescriptorsAreSet() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        for (WebAction webAction : webController.getActions()) {
            if (webAction.getMethod().equals(webController.getClass().getMethod("testVoid"))) {
                Assert.assertEquals(HttpMethod.GET, webAction.getHttpMethod());
                Assert.assertEquals("/void", webAction.getPath());
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("testPostParameter", String.class))) {
                Assert.assertEquals(HttpMethod.POST, webAction.getHttpMethod());
                Assert.assertEquals("/testPostParameter", webAction.getPath());
            }
        }
    }

    @Test
    public void getActions_actionsCanBeFound() throws NoSuchMethodException {

        Controller.Action testVoid = null;
        Controller.Action testPostParameter = null;
        Controller.Action testServerError = null;
        for (WebAction webAction : webController.getActions()) {
            if (webAction.getMethod().equals(webController.getClass().getMethod("testVoid"))) {
                testVoid = webAction;
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("testPostParameter", String.class))) {
                testPostParameter = webAction;
            } else if (webAction.getMethod().equals(webController.getClass().getMethod("testServerError"))) {
                testServerError = webAction;
            }
        }
        Assert.assertNotNull(testVoid);
        Assert.assertNotNull(testPostParameter);
        Assert.assertNotNull(testServerError);
    }

    @Test(expected = InvocationTargetException.class)
    public void callServerErrorAction_exceptionIsThrown() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        webController.getClass().getMethod("testServerError").invoke(webController);
    }

}
