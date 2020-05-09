package org.fluentness.engine;

import org.fluentness.engine.algebra.Vector3f;
import org.fluentness.engine.algebra.VectorFactory;
import org.fluentness.engine.display.Display;
import org.fluentness.engine.entity.Object;
import org.fluentness.engine.entity.*;
import org.fluentness.engine.memory.Memory;
import org.fluentness.engine.model.ObjectModel;
import org.fluentness.service.render.ObjectRender;
import org.fluentness.service.render.TerrainRender;
import org.lwjgl.glfw.GLFWKeyCallback;

import java.util.*;

import static org.lwjgl.glfw.GLFW.*;

public abstract class AbstractScene {

    // entities
    private Vector3f background = VectorFactory.blackRgb();
    private Camera camera = new Camera().setTranslation(new Vector3f(0, 2, 2));
    private Light light = new Light().setTranslation(new Vector3f(0, 10, -20));
    private Fog fog = new Fog();
    private final Map<ObjectModel, List<Object>> objectMap = new HashMap<>();
    private final List<Terrain> terrainList = new LinkedList<>();

    private final Display display;
    private final ObjectRender objectRender;
    private final TerrainRender terrainRender;

    public AbstractScene(String title) {
        display = new Display(title);
        objectRender = new ObjectRender(this);
        terrainRender = new TerrainRender(this);
    }

    public Vector3f getBackground() {
        return background;
    }

    public AbstractScene setBackground(Vector3f background) {
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

    public AbstractScene setFog(Fog fog) {
        this.fog = fog;
        return this;
    }

    public Display getDisplay() {
        return display;
    }

    public void addEntity(Object... objects) {
        for (Object object : objects) {
            if (!objectMap.containsKey(object.getModel())) {
                objectMap.put(object.getModel(), new LinkedList<>());
            }
            objectMap.get(object.getModel()).add(object);
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
            objectRender.render(objectMap);
            loop();
            display.update();
        }
        Memory.cleanUp();
        display.close();
    }

    protected abstract void loop();
}
