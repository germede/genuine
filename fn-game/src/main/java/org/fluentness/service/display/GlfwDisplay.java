package org.fluentness.service.display;

import org.fluentness.service.algebra.Vector3f;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.GL_FALSE;

public class GlfwDisplay implements Display {

    private final int width = 1280;
    private final int height = 720;
    private final int maxFps = 120;

    private final long window;
    // strong references avoiding garbage collector to delete them
    private final GLFWErrorCallback errorCallback;

    public GlfwDisplay(String title) {
        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        glfwInit();
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        window = glfwCreateWindow(width, height, title, 0, 0);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glfwShowWindow(window);
    }

    @Override
    public long getWindow() {
        return window;
    }

    @Override
    public void clear(Vector3f background) {
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(background.x, background.y, background.z, 1);
    }

    @Override
    public void update() {
        glfwPollEvents();
        glfwSwapBuffers(window);
    }

    @Override
    public boolean shouldClose() {
        return glfwWindowShouldClose(window);
    }

    @Override
    public void close() {
        glfwDestroyWindow(window);
    }
}
