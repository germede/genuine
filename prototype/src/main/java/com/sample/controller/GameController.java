package com.sample.controller;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.controller.scene.Scene;
import org.fluentness.service.display.Display;
import org.lwjgl.glfw.GLFWScrollCallback;

import static org.lwjgl.glfw.GLFW.*;

public class GameController extends AbstractGameController<Game> {

    private double dy;
    private double dx;

    public GameController(Game game, Display display) {
        super(game, display);


        glfwSetScrollCallback(display.getWindow(), new GLFWScrollCallback() {
            @Override
            public void invoke(long l, double dx, double dy) {
                GameController.this.dx = dx;
                GameController.this.dy = dy;
            }
        });
    }

    @Override
    public void loop() {

        Scene scene = game.scene;
        game.player.control(
            display.getDelta(),
            isKeyPressed(GLFW_KEY_W) ? 1 : isKeyPressed(GLFW_KEY_S) ? -1 : 0,
            isKeyPressed(GLFW_KEY_D) ? 1 : isKeyPressed(GLFW_KEY_A) ? -1 : 0,
            isKeyPressed(GLFW_KEY_SPACE) ? 1 : 0
        );
//        System.out.println(dx + " " + dy);
//        game.camera.follow(game.player);
    }


}
