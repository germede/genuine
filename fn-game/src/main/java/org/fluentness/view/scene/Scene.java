package org.fluentness.view.scene;

import org.fluentness.model.Shape;
import org.fluentness.view.GameTemplate;
import org.fluentness.view.scene.entity.Entity;
import org.fluentness.view.scene.entity.Terrain;
import org.fluentness.view.scene.environment.Background;
import org.fluentness.view.scene.environment.Camera;
import org.fluentness.view.scene.environment.Fog;
import org.fluentness.view.scene.environment.Light;

import java.util.*;

public class Scene implements GameTemplate {

    private final Map<Shape, List<Entity>> entities = new HashMap<>();
    private final List<Terrain> terrains = new LinkedList<>();

    private Background background;
    private Camera camera;
    private Light light;
    private Fog fog;

    public Scene(Background background, Camera camera, Light light, Fog fog) {
        this.background = background;
        this.camera = camera;
        this.light = light;
        this.fog = fog;
    }

    public Background getBackground() {
        return background;
    }

    public Scene setBackground(Background background) {
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

    public Map<Shape, List<Entity>> getEntities() {
        return entities;
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void add(SceneElement[] elements) {
        for (SceneElement element : elements) {
            if (element instanceof Entity) {
                Entity entity = (Entity) element;
                if (!entities.containsKey(entity.getShape())) {
                    entities.put(entity.getShape(), new LinkedList<>());
                }
                entities.get(entity.getShape()).add(entity);
            } else if (element instanceof Terrain) {
                Terrain terrain = (Terrain) element;
                terrains.add(terrain);
            }
        }
    }
}
