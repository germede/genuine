package com.sample.controller;

import com.sample.view.Game;
import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.display.Display;

import static org.lwjgl.glfw.GLFW.*;

public class GameController extends AbstractGameController<Game> {

    private final Animator animator;

    public GameController(Game game, Display display, Animator animator) {
        super(game, display);
        this.animator = animator;

        glfwSetKeyCallback(display.getWindow(), this::keyListener);
        glfwSetScrollCallback(display.getWindow(), this::scrollListener);
    }

    private double lastCursorPositionX, lastCursorPositionY;

    @Override
    public void loop() {
        game.player.floor = game.terrain.getHeightAt(game.player.translation.x, game.player.translation.z);
        game.player.control(display.getDelta(),
            isKeyPressed(GLFW_KEY_W) ? 200 : isKeyPressed(GLFW_KEY_S) ? -200 : 0,
            isKeyPressed(GLFW_KEY_D) ? 200 : isKeyPressed(GLFW_KEY_A) ? -200 : 0,
            isKeyPressed(GLFW_KEY_SPACE) ? 200 : 0
        );

        double currentCursorPositionX = getCursorPositionX();
        double currentCursorPositionY = getCursorPositionY();
        if (isMouseButtonPressed(GLFW_MOUSE_BUTTON_3)) {
            game.camera.followYaw += currentCursorPositionX - lastCursorPositionX;
            game.camera.followPitch += currentCursorPositionY - lastCursorPositionY;
        } else {
            // reset camera when moving
            if (isKeyPressed(GLFW_KEY_W)) {
                if (game.camera.followPitch > 30) {
                    game.camera.followPitch--;
                } else if (game.camera.followPitch < 28) {
                    game.camera.followPitch++;
                }
                if (game.camera.followYaw > 1) {
                    game.camera.followYaw--;
                } else if (game.camera.followYaw < -1) {
                    game.camera.followYaw++;
                }
            }
        }
        lastCursorPositionX = currentCursorPositionX;
        lastCursorPositionY = currentCursorPositionY;

        game.camera.follow(game.player);
    }

    private void scrollListener(long window, double dx, double dy) {
        animator.animate(Animator.BEZIER, game.camera.zoom, game.camera.zoom + (float) -dy * 50, y -> game.camera.zoom = y, 300);
    }

    private void keyListener(long window, int key, int ignore1, int ignore2, int ignore3) {
        switch (key) {
            case GLFW_KEY_UP:
                game.light.translation.z -= 10;
                break;
            case GLFW_KEY_DOWN:
                game.light.translation.z += 10;
                break;
            case GLFW_KEY_RIGHT:
                game.light.translation.x += 10;
                break;
            case GLFW_KEY_LEFT:
                game.light.translation.x -= 10;
                break;
        }
    }
}
