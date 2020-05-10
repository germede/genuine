package org.fluentness.view;

import org.fluentness.service.algebra.DefaultAlgebra;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.memory.DefaultMemory;
import org.fluentness.model.shape.ShapeModel;
import org.fluentness.controller.Input;
import org.fluentness.service.display.Display;
import org.fluentness.service.display.GlfwDisplay;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.view.entity.Entity;
import org.fluentness.view.entity.Terrain;
import org.fluentness.view.environment.Camera;
import org.fluentness.view.environment.Fog;
import org.fluentness.view.environment.Light;
import org.lwjgl.glfw.GLFWKeyCallback;

import java.util.*;

import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;

public class Scene {

    // entities
    private Vector3f background = DefaultAlgebra.blackRgb();
    private Camera camera = new Camera().setTranslation(new Vector3f(0, 2, 2));
    private Light light = new Light().setTranslation(new Vector3f(0, 10, -20));
    private Fog fog = new Fog();
    private final Map<ShapeModel, List<Entity>> objectMap = new HashMap<>();
    private final List<Terrain> terrainList = new LinkedList<>();

    private final Input input;
    private final Display display;
    private final EntityRender entityRender;
    private final TerrainRender terrainRender;

    public Scene(String title) {
        input = new Input(this);
        display = new GlfwDisplay(title);
        entityRender = new EntityRender(this);
        terrainRender = new TerrainRender(this);
    }

    public Vector3f getBackground() {
        return background;
    }

    public Scene setBackground(Vector3f background) {
        this.background = background;
        return this;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public Fog getFog() {
        return fog;
    }

    public Scene setFog(Fog fog) {
        this.fog = fog;
        return this;
    }

    public Display getDisplay() {
        return display;
    }

    public void addEntity(Entity... entities) {
        for (Entity entity : entities) {
            if (!objectMap.containsKey(entity.getShape())) {
                objectMap.put(entity.getShape(), new LinkedList<>());
            }
            objectMap.get(entity.getShape()).add(entity);
        }
    }

    public void addEntity(Terrain... terrains) {
        terrainList.addAll(Arrays.asList(terrains));
    }

    public void addInput(GLFWKeyCallback glfwKeyCallback) {
        glfwSetKeyCallback(display.getWindow(), glfwKeyCallback);
    }

    public void run() {
        while (!display.shouldClose()) {
            display.clear(background);
            terrainRender.render(terrainList);
            entityRender.render(objectMap);
            input.handle();
            display.update();
        }
        DefaultMemory.cleanUp();
        display.close();
    }

    protected void loop() {

    }
}
