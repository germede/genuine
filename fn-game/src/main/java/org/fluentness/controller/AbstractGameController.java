package org.fluentness.controller;

import org.fluentness.service.display.Display;

import static org.lwjgl.glfw.GLFW.*;

public abstract class AbstractGameController<V extends AbstractGame> implements Controller {

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

    protected final boolean isKeyPressed(int glfwKey) {
        return glfwGetKey(display.getWindow(), glfwKey) == GLFW_PRESS;
    }

    protected double getCursorPositionX() {
        double[] posX = new double[1];
        double[] posY = new double[1];
        glfwGetCursorPos(display.getWindow(),posX,posY);
        return posX[0];
    }

}
