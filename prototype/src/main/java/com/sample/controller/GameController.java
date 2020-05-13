package com.sample.controller;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.display.Display;

import static org.fluentness.controller.input.Input.*;
import static org.lwjgl.glfw.GLFW.*;

public class GameController extends AbstractGameController<Game> {

    private double lastCursorPositionX, lastCursorPositionY;

    public GameController(Game game, Display display) {
        super(game, display);
    }

    @Override
    public void loop() {
        game.player.control(display.getDelta(),
            isKeyPressed(GLFW_KEY_W) ? 200 : isKeyPressed(GLFW_KEY_S) ? -200 : 0,
            isKeyPressed(GLFW_KEY_D) ? 200 : isKeyPressed(GLFW_KEY_A) ? -200 : 0,
            isKeyPressed(GLFW_KEY_SPACE) ? 200 : 0
        );

        double currentCursorPositionX = getCursorPositionX();
        double currentCursorPositionY = getCursorPositionY();
        if(isMouseButtonPressed(GLFW_MOUSE_BUTTON_3)) {
            game.camera.followYaw += currentCursorPositionX-lastCursorPositionX;
            game.camera.followPitch += currentCursorPositionY-lastCursorPositionY;
        } else {
            // reset camera when moving
            if (isKeyPressed(GLFW_KEY_W)) {
                if (game.camera.followPitch > 30){
                    game.camera.followPitch--;
                } else if (game.camera.followPitch < 28){
                    game.camera.followPitch++;
                }
                if (game.camera.followYaw > 1){
                    game.camera.followYaw--;
                } else if (game.camera.followYaw < -1){
                    game.camera.followYaw++;
                }
            }
        }
        lastCursorPositionX = currentCursorPositionX;
        lastCursorPositionY = currentCursorPositionY;

        game.camera.follow(game.player);
    }

    @Action(SCROLL)
    void scrollListener(double dx, double dy) {
        game.camera.zoom -= dy*10;
    }

}
