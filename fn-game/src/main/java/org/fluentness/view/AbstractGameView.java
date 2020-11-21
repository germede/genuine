package org.fluentness.view;

import org.fluentness.model.*;
import org.fluentness.model.environment.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.GL_FALSE;

public abstract class AbstractGameView implements View {

    private final CharSequence title;

    public Background background = new Background(0, 0, 0);
    public Camera camera = new Camera(0, 10, -10);
    public Light light = new Light(0, 10, 0);
    public Fog fog = new Fog(0, 0);
    public final List<Terrain> terrains = new LinkedList<>();
    public final Map<String, List<Entity>> entities = new HashMap<>();

    private long lastTime = System.currentTimeMillis();
    private int fps;

    private final long window;
    // strong references avoiding garbage collector to delete them
    private final GLFWErrorCallback errorCallback;

    private float delta;
    private float totalDelta;

    public AbstractGameView(CharSequence title, int width, int height, boolean fullscreen) {
        this.title = title;

        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        glfwInit();
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        window = glfwCreateWindow(width, height, title, fullscreen ? glfwGetPrimaryMonitor() : 0, 0);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glfwShowWindow(window);
    }

    @Override
    public CharSequence getTitle() {
        return title;
    }

    public void addEntity(Entity entity) {
        String key = entity.mesh.getId() + "-" + entity.texture.getId();
        if (!this.entities.containsKey(key)) {
            this.entities.put(key, new LinkedList<>());
        }
        this.entities.get(key).add(entity);
    }

    public int getFps() {
        return fps;
    }

    public float getDelta() {
        return delta;
    }

    public long getWindowId() {
        return window;
    }

    public void clear(float r, float g, float b) {
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(r, g, b, 1);
    }

    public void update() {
        long currentTime = System.currentTimeMillis();
        delta = (currentTime - lastTime) / 1000f;
        totalDelta += delta;
        fps = (int) (1 / delta);
        lastTime = currentTime;
        if (totalDelta > 1) {
            totalDelta = 0;
        }

        glfwPollEvents();
        glfwSwapBuffers(window);
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(window);
    }

    public void close() {
        glfwDestroyWindow(window);
    }

}
