package org.fluentness.prototype.controller;

import org.fluentness.model.Player;
import org.fluentness.model.Terrain;
import org.fluentness.prototype.repository.PlayerRepository;
import org.fluentness.prototype.repository.TerrainRepository;
import org.fluentness.prototype.view.GameView;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.display.Display;

import static org.lwjgl.glfw.GLFW.*;

public class GameController extends org.fluentness.controller.GameController<GameView> {

    private final Animator animator;
    private final Player player;
    private final Terrain terrain;

    public GameController(GameView gameView, Display display, Animator animator, PlayerRepository playerRepository, TerrainRepository terrainRepository) {
        super(gameView, display);
        this.animator = animator;
        this.player = playerRepository.selectAll().get(0);
        this.terrain = terrainRepository.selectAll().get(0);

        glfwSetKeyCallback(display.getWindowId(), this::keyListener);
        glfwSetScrollCallback(display.getWindowId(), this::scrollListener);
    }

    private double lastCursorPositionX, lastCursorPositionY;

    @Override
    public void loop() {
        player.floor = terrain.getHeightAt(player.x, player.z);
        player.control(display.getDelta(),
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
                    gameView.camera.followPitch%=360;
                } else if (gameView.camera.followPitch < 28) {
                    gameView.camera.followPitch++;
                    gameView.camera.followPitch%=360;
                }
                if (gameView.camera.followYaw > 1) {
                    gameView.camera.followYaw--;
                    gameView.camera.followYaw%=360;
                } else if (gameView.camera.followYaw < -1) {
                    gameView.camera.followYaw++;
                    gameView.camera.followYaw%=360;
                }
            }
        }
        lastCursorPositionX = currentCursorPositionX;
        lastCursorPositionY = currentCursorPositionY;

        gameView.camera.follow(player);
    }

    private void scrollListener(long window, double dx, double dy) {
        animator.animate(Animator.BEZIER, gameView.camera.zoom, gameView.camera.zoom + (float) -dy * 50, y -> gameView.camera.zoom = y, 300);
    }

    private void keyListener(long window, int key, int ignore1, int ignore2, int ignore3) {
        int z = 100;
        switch (key) {
            case GLFW_KEY_UP:
                gameView.light.z -= z;
                break;
            case GLFW_KEY_DOWN:
                gameView.light.z += z;
                break;
            case GLFW_KEY_RIGHT:
                gameView.light.x += z;
                break;
            case GLFW_KEY_LEFT:
                gameView.light.x -= z;
                break;
        }
    }
}
