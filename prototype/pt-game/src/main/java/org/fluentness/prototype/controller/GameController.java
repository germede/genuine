package org.fluentness.prototype.controller;

import org.fluentness.prototype.view.GameView;
import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.display.Display;

import static org.lwjgl.glfw.GLFW.*;

public class GameController extends AbstractGameController<GameView> {

    private final Animator animator;

    public GameController(GameView gameView, Display display, Animator animator) {
        super(gameView, display);
        this.animator = animator;

        glfwSetKeyCallback(display.getWindow(), this::keyListener);
        glfwSetScrollCallback(display.getWindow(), this::scrollListener);
    }

    private double lastCursorPositionX, lastCursorPositionY;

    @Override
    public void loop() {
        gameView.player.floor = gameView.terrain.getHeightAt(gameView.player.translation.x, gameView.player.translation.z);
        gameView.player.control(display.getDelta(),
            isKeyPressed(GLFW_KEY_W) ? 200 : isKeyPressed(GLFW_KEY_S) ? -200 : 0,
            isKeyPressed(GLFW_KEY_D) ? 200 : isKeyPressed(GLFW_KEY_A) ? -200 : 0,
            isKeyPressed(GLFW_KEY_SPACE) ? 200 : 0
        );

        double currentCursorPositionX = getCursorPositionX();
        double currentCursorPositionY = getCursorPositionY();
        if (isMouseButtonPressed(GLFW_MOUSE_BUTTON_3)) {
            gameView.camera.followYaw += currentCursorPositionX - lastCursorPositionX;
            gameView.camera.followPitch += currentCursorPositionY - lastCursorPositionY;
        } else {
            // reset camera when moving
            if (isKeyPressed(GLFW_KEY_W)) {
                if (gameView.camera.followPitch > 30) {
                    gameView.camera.followPitch--;
                } else if (gameView.camera.followPitch < 28) {
                    gameView.camera.followPitch++;
                }
                if (gameView.camera.followYaw > 1) {
                    gameView.camera.followYaw--;
                } else if (gameView.camera.followYaw < -1) {
                    gameView.camera.followYaw++;
                }
            }
        }
        lastCursorPositionX = currentCursorPositionX;
        lastCursorPositionY = currentCursorPositionY;

        gameView.camera.follow(gameView.player);
    }

    private void scrollListener(long window, double dx, double dy) {
        animator.animate(Animator.BEZIER, gameView.camera.zoom, gameView.camera.zoom + (float) -dy * 50, y -> gameView.camera.zoom = y, 300);
    }

    private void keyListener(long window, int key, int ignore1, int ignore2, int ignore3) {
        switch (key) {
            case GLFW_KEY_UP:
                gameView.light.translation.z -= 10;
                break;
            case GLFW_KEY_DOWN:
                gameView.light.translation.z += 10;
                break;
            case GLFW_KEY_RIGHT:
                gameView.light.translation.x += 10;
                break;
            case GLFW_KEY_LEFT:
                gameView.light.translation.x -= 10;
                break;
        }
    }
}
