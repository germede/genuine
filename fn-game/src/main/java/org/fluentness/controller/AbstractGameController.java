package org.fluentness.controller;

import org.fluentness.service.display.Display;

import java.lang.annotation.*;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;

public abstract class AbstractGameController<V extends AbstractGame> implements ActionController {

    protected final V game;
    protected final Display display;

    public AbstractGameController(V game, Display display) {
        this.game = game;
        this.display = display;

        Arrays.stream(getActions()).forEach(action -> {
//
//            switch (action.getAnnotation(Action.class).input()) {
//                case KEY:
//                    glfwSetKeyCallback(display.getWindow(), this::keyInput);
//
//            }
//
//
//            glfwSetCharCallback(display.getWindow(), methodReference);
//            glfwSetCharModsCallback(display.getWindow(), methodReference);
//            glfwSetMouseButtonCallback(display.getWindow(), methodReference);
//            glfwSetCursorPosCallback(display.getWindow(), methodReference);
//            glfwSetCursorEnterCallback(display.getWindow(), methodReference);
//            glfwSetScrollCallback(display.getWindow(), methodReference);
//            glfwSetDropCallback(display.getWindow(), methodReference);
//            glfwSetJoystickCallback(methodReference);

        });
    }


    @Override
    public final Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    public enum Input {
        KEY,
        CHAR,
        CHAR_MODS,
        MOUSE_BUTTON,
        CURSOR_POS,
        CURSOR_ENTER,
        SCROLL,
        DROP,
        JOYSTICK,
    }

    public final V getGame() {
        return game;
    }

    public abstract void loop();

    protected final boolean isKeyPressed(int glfwKey) {
        return glfwGetKey(display.getWindow(), glfwKey) == GLFW_PRESS;
    }

    protected boolean isMouseButtonPressed(int glfwMouseButton) {
        return glfwGetMouseButton(display.getWindow(), glfwMouseButton) == 1;
    }

    private final double[] posHolder = new double[1];

    protected double getCursorPositionX() {
        glfwGetCursorPos(display.getWindow(), posHolder, null);
        return posHolder[0];
    }

    protected double getCursorPositionY() {
        glfwGetCursorPos(display.getWindow(), null, posHolder);
        return posHolder[0];
    }

}
