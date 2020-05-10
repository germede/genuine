package org.fluentness.view;

import org.fluentness.model.Shape;
import org.fluentness.view.entity.Entity;
import org.fluentness.view.entity.Terrain;
import org.fluentness.view.environment.Background;
import org.fluentness.view.environment.Camera;
import org.fluentness.view.environment.Fog;
import org.fluentness.view.environment.Light;

import java.util.*;

public abstract class AbstractGameView implements View {

    private final Background background;
    private final Camera camera;
    private final Light light;
    private final Fog fog;
    private final Terrain[] terrains;
    private final Map<Shape, List<Entity>> entities = new HashMap<>();

    protected static Background background(float r, float g, float b) {
        return new Background(r, g, b);
    }

    protected static Camera camera(float x, float y, float z) {
        return new Camera(x, y, z);
    }

    protected static Light light(float x, float y, float z) {
        return new Light(x, y, z);
    }

    protected static Fog fog(float density, float gradient) {
        return new Fog(density, gradient);
    }

    public AbstractGameView(Background background, Camera camera, Light light, Fog fog, Terrain[] terrains, Entity[]... entities) {
        this.background = background;
        this.camera = camera;
        this.light = light;
        this.fog = fog;
        this.terrains = terrains;
        for (Entity[] elementArray : entities) {
            for (Entity entity : elementArray) {
                if (!this.entities.containsKey(entity.getShape())) {
                    this.entities.put(entity.getShape(), new LinkedList<>());
                }
                this.entities.get(entity.getShape()).add(entity);
            }
        }
    }

    public Background getBackground() {
        return background;
    }

    public Camera getCamera() {
        return camera;
    }

    public Light getLight() {
        return light;
    }

    public Fog getFog() {
        return fog;
    }

    public Terrain[] getTerrains() {
        return terrains;
    }

    public Map<Shape, List<Entity>> getEntities() {
        return entities;
    }

}
