package org.fluentness.controller;

import org.fluentness.service.display.Display;
import org.fluentness.view.AbstractGame;

import static org.lwjgl.glfw.GLFW.*;

public abstract class AbstractGameController<V extends AbstractGame> implements Controller {

    private final double[] posHolder = new double[1];

    protected final V game;
    protected final Display display;

    public AbstractGameController(V game, Display display) {
        this.game = game;
        this.display = display;
    }

    public final V getGame() {
        return game;
    }

    public abstract void loop();

    protected final boolean isKeyPressed(int key) {
        return glfwGetKey(display.getWindow(), key) == GLFW_PRESS;
    }

    protected boolean isMouseButtonPressed(int mouseButton) {
        return glfwGetMouseButton(display.getWindow(), mouseButton) == 1;
    }

    protected double getCursorPositionX() {
        glfwGetCursorPos(display.getWindow(), posHolder, null);
        return posHolder[0];
    }

    protected double getCursorPositionY() {
        glfwGetCursorPos(display.getWindow(), null, posHolder);
        return posHolder[0];
    }

}
