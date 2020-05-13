package com.sample.controller;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.display.Display;

import static org.lwjgl.glfw.GLFW.*;

public class GameController extends AbstractGameController<Game> {

    private double dy;
    private double dx;

    public GameController(Game game, Display display) {
        super(game, display);
//        keyListener();
    }

    public void doSomething(int key, int scancode, int action, int mods) {
        System.out.println("yes");
    }

    @Override
    public void loop() {

        game.player.control(display.getDelta(),
            isKeyPressed(GLFW_KEY_W) ? 200 : isKeyPressed(GLFW_KEY_S) ? -200 : 0,
            isKeyPressed(GLFW_KEY_D) ? 200 : isKeyPressed(GLFW_KEY_A) ? -200 : 0,
            isKeyPressed(GLFW_KEY_SPACE) ? 200 : 0
        );
        game.camera.follow(game.player,
            (float) dy,
            0,
            0
        );
    }

}
