package com.sample.controller;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.display.Display;

import static org.fluentness.controller.Input.LOOP;
import static org.fluentness.controller.Input.SCROLL;
import static org.lwjgl.glfw.GLFW.*;

public class GameController extends AbstractGameController<Game> {

    public GameController(Game game, Display display) {
        super(game, display);
    }

    @Action(LOOP)
    public void loop() {
        game.player.control(display.getDelta(),
            isKeyPressed(GLFW_KEY_W) ? 200 : isKeyPressed(GLFW_KEY_S) ? -200 : 0,
            isKeyPressed(GLFW_KEY_D) ? 200 : isKeyPressed(GLFW_KEY_A) ? -200 : 0,
            isKeyPressed(GLFW_KEY_SPACE) ? 200 : 0
        );
        game.camera.follow(game.player,
            0,
            0,
            0
        );
    }


    @Action(SCROLL)
    public void scrollListener(double dx, double dy) {
        game.camera.zoom -= dy*10;
    }



}
