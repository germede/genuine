package com.sample.controller;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.display.Display;

import static org.lwjgl.glfw.GLFW.*;

public class GameController extends AbstractGameController<Game> {


    public GameController(Game game, Display display) {
        super(game, display);
    }

    @Override
    public void loop() {
        game.player.move(display.getDelta(),
            isKeyPressed(GLFW_KEY_W),
            isKeyPressed(GLFW_KEY_A),
            isKeyPressed(GLFW_KEY_S),
            isKeyPressed(GLFW_KEY_D)
        );

        game.camera.move(display.getDelta(),
            isKeyPressed(GLFW_KEY_UP),
            isKeyPressed(GLFW_KEY_LEFT),
            isKeyPressed(GLFW_KEY_DOWN),
            isKeyPressed(GLFW_KEY_RIGHT)
        );
    }


}
