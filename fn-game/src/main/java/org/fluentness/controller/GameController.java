package org.fluentness.controller;

import org.fluentness.view.AbstractGameView;

import static org.lwjgl.glfw.GLFW.*;

public abstract class GameController<V extends AbstractGameView> implements Controller {

    private final double[] posHolder = new double[1];

    protected final V gameView;

    public GameController(V gameView) {
        this.gameView = gameView;
    }

    public final V getGameView() {
        return gameView;
    }

    public abstract void loop();

    protected final boolean isKeyPressed(int key) {
        return glfwGetKey(gameView.getWindowId(), key) == GLFW_PRESS;
    }

    protected boolean isMouseButtonPressed(int mouseButton) {
        return glfwGetMouseButton(gameView.getWindowId(), mouseButton) == 1;
    }

    protected double getCursorPositionX() {
        glfwGetCursorPos(gameView.getWindowId(), posHolder, null);
        return posHolder[0];
    }

    protected double getCursorPositionY() {
        glfwGetCursorPos(gameView.getWindowId(), null, posHolder);
        return posHolder[0];
    }

}
