package org.fluentness.controller;

import org.fluentness.service.display.Display;
import org.fluentness.view.AbstractGameView;

import static org.lwjgl.glfw.GLFW.*;

public abstract class GameController<V extends AbstractGameView> implements Controller {

    private final double[] posHolder = new double[1];

    protected final V gameView;
    protected final Display display;

    public GameController(V gameView, Display display) {
        this.gameView = gameView;
        this.display = display;
    }

    public final V getGameView() {
        return gameView;
    }

    public abstract void loop();

    protected final boolean isKeyPressed(int key) {
        return glfwGetKey(display.getWindowId(), key) == GLFW_PRESS;
    }

    protected boolean isMouseButtonPressed(int mouseButton) {
        return glfwGetMouseButton(display.getWindowId(), mouseButton) == 1;
    }

    protected double getCursorPositionX() {
        glfwGetCursorPos(display.getWindowId(), posHolder, null);
        return posHolder[0];
    }

    protected double getCursorPositionY() {
        glfwGetCursorPos(display.getWindowId(), null, posHolder);
        return posHolder[0];
    }

}
