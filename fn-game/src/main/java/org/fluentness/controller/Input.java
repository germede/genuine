package org.fluentness.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.lwjgl.glfw.GLFW.*;

public enum Input {
    LOOP("()"),
    KEY("(int,int,int)"),
    CHAR("(int)"),
    CHAR_MODS("(int,int)"),
    MOUSE_BUTTON("(int,int,int)"),
    CURSOR_POS("(double,double)"),
    CURSOR_ENTER("(boolean)"),
    SCROLL("(double,double)"),
    DROP("(int,long)"),
    JOYSTICK("(int,int)"),
    ;

    private final String signature;

    Input(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setCallback(long window, AbstractGameController controller, Method action) {
        switch (this) {
            case LOOP:
                glfwSetWindowRefreshCallback(window, l -> invokeAction(controller, action));
                break;
            case KEY:
                glfwSetKeyCallback(window, (l, i, i1, i2, i3) -> invokeAction(controller, action, i, i1, i2, i3));
                break;
            case CHAR:
                glfwSetCharCallback(window, (l, i) -> invokeAction(controller, action, i));
                break;
            case CHAR_MODS:
                glfwSetCharModsCallback(window, (l, i, i1) -> invokeAction(controller, action, i, i1));
                break;
            case MOUSE_BUTTON:
                glfwSetMouseButtonCallback(window, (l, i, i1, i2) -> invokeAction(controller, action, i, i1, i2));
                break;
            case CURSOR_POS:
                glfwSetCursorPosCallback(window, (l, v, v1) -> invokeAction(controller, action, v, v1));
                break;
            case CURSOR_ENTER:
                glfwSetCursorEnterCallback(window, (l, b) -> invokeAction(controller, action, b));
                break;
            case SCROLL:
                glfwSetScrollCallback(window, (l, v, v1) -> invokeAction(controller, action, v, v1));
                break;
            case DROP:
                glfwSetDropCallback(window, (l, i, l1) -> invokeAction(controller, action, i, l1));
                break;
            case JOYSTICK:
                glfwSetJoystickCallback((i, i1) -> invokeAction(controller, action, i, i1));
                break;
        }
    }


    private void invokeAction(AbstractGameController controller, Method action, Object... parameters) {
        try {
            action.setAccessible(true);
            action.invoke(controller, parameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
