package org.fluentness.controller;

import org.fluentness.repository.Shape;
import org.fluentness.controller.entity.Entity;
import org.fluentness.controller.entity.Terrain;
import org.fluentness.controller.environment.Background;
import org.fluentness.controller.environment.Camera;
import org.fluentness.controller.environment.Fog;
import org.fluentness.controller.environment.Light;

import java.util.*;

public class Scene implements GameView {

    private final Background background;
    private final Camera camera;
    private final Light light;
    private final Fog fog;
    private final Terrain[] terrains;
    private final Map<Shape, List<Entity>> entities = new HashMap<>();

    Scene(Background background, Camera camera, Light light, Fog fog, Terrain[] terrains, Entity[]... entities) {
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
