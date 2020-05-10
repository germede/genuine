package org.fluentness.service.display;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import java.util.Timer;
import java.util.TimerTask;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.GL_FALSE;

public class GlfwDisplay implements Display {

    private long lastTime = System.currentTimeMillis();
    private int fps;

    private final long window;
    // strong references avoiding garbage collector to delete them
    private final GLFWErrorCallback errorCallback;

    private final Log log;
    private long currentTime;
    private float delta;

    public GlfwDisplay(Configuration configuration, Log log) {
        this.log = log;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                log.debug("%s FPS", fps);
            }
        }, 0, 1000);

        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        glfwInit();
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        window = glfwCreateWindow(configuration.get(WIDTH), configuration.get(HEIGHT), configuration.get(TITLE), 0, 0);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glfwShowWindow(window);
    }

    @Override
    public int getFps() {
        return fps;
    }

    @Override
    public float getDelta() {
        return delta;
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
        long currentTime = System.currentTimeMillis();
        delta = (currentTime - lastTime) / 1000f;
        fps = (int) (1 / delta);
        lastTime = currentTime;

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
