package org.fluentness.game;

import org.fluentness.engine.AbstractScene;
import org.fluentness.engine.algebra.Vector3f;
import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.*;

public class InputManager extends GLFWKeyCallback {

    private static final int CAMERA_STEP = 5;

    private final AbstractScene scene;

    public InputManager(AbstractScene scene) {
        this.scene = scene;
    }

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        System.out.println("INPUT!");
    }

    public void handleCamera() {
        Vector3f translation = scene.getCamera().getTranslation();
        Vector3f rotation = scene.getCamera().getRotation();
        long window = scene.getDisplay().getWindow();

        if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) {
            translation.z -= CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) {
            translation.z -= CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS) {
            translation.x -= CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS) {
            translation.z += CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS) {
            translation.x += CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_E) == GLFW_PRESS) {
            translation.y += CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_Q) == GLFW_PRESS) {
            translation.y -= CAMERA_STEP;
        }

        if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS) {
            rotation.x -= CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS) {
            rotation.y -= CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS) {
            rotation.x += CAMERA_STEP;
        }
        if (glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS) {
            rotation.y += CAMERA_STEP;
        }
    }
}
