package org.fluentness.controller;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ConsoleControllerTest {

    private ConsoleController emptyConsoleController = new ConsoleController() {
    };
    private ConsoleController fullConsoleController = new ConsoleController() {

        @Action
        public void aPublicAction() {
        }

        @Action
        protected void aProtectedAction() {
        }

        @Action
        void aPackagePrivateAction() {
        }

        @Action
        private void aPrivateAction() {
        }

        @Action
        public int aNotVoidAction() {
            return 0;
        }

        @Action(description = "test", category = "test")
        public void anActionWithDescriptionAndCategory() {
        }

        @Action
        public void anActionWithParameters(int i, String s) {
        }

        public void notAnAction() {
        }
    };

    @Test
    public void getActionsOnFullConsoleController() {
        Map<String, Method> actions = fullConsoleController.getActionMap();

        Assert.assertTrue(actions.containsKey("aPublicAction"));
        Assert.assertFalse(actions.containsKey("aProtectedAction"));
        Assert.assertFalse(actions.containsKey("aPackagePrivateAction"));
        Assert.assertFalse(actions.containsKey("aPrivateAction"));
        Assert.assertFalse(actions.containsKey("notAnAction"));
        Assert.assertTrue(actions.containsKey("aNotVoidAction"));
        Assert.assertTrue(actions.containsKey("anActionWithDescriptionAndCategory"));
        Assert.assertTrue(actions.containsKey("anActionWithParameters"));
        Assert.assertFalse(actions.containsKey("notAnAction"));
        Assert.assertEquals(5, actions.size());
    }

    @Test
    public void getActionsOnEmptyConsoleController() {
        Map<String, Method> actions = emptyConsoleController.getActionMap();

        Assert.assertTrue(actions.containsKey("help"));
        Assert.assertEquals(1, actions.size());
    }

    @Test
    public void helpOnBothControllers() {
        emptyConsoleController.help();
        fullConsoleController.help();
    }

    @Test
    public void helpOnBothControllersUsingReflection() throws InvocationTargetException, IllegalAccessException {
        emptyConsoleController.getActionMap().get("help").invoke(emptyConsoleController);
        fullConsoleController.getActionMap().get("help").invoke(emptyConsoleController);
    }

    @Test(expected = NullPointerException.class)
    public void notAnActionOnFullConsoleController() throws InvocationTargetException, IllegalAccessException {
        emptyConsoleController.getActionMap().get("notAnAction").invoke(emptyConsoleController);
    }
}
