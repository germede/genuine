package org.fluentness.controller.scene;

import org.fluentness.controller.input.GameView;
import org.fluentness.controller.scene.camera.Camera;
import org.fluentness.controller.scene.entity.Entities;
import org.fluentness.controller.scene.entity.Entity;
import org.fluentness.controller.scene.environment.Background;
import org.fluentness.controller.scene.environment.Fog;
import org.fluentness.controller.scene.light.Light;
import org.fluentness.controller.scene.terrain.Terrain;
import org.fluentness.repository.shape.Shape;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Scene implements GameView {

    public Background background;
    public Camera camera;
    public Light light;
    public Fog fog;
    public final List<Terrain> terrains = new LinkedList<>();
    public final Map<Shape, List<Entity>> entities = new HashMap<>();

    public Scene(SceneElement[] sceneElements) {
        for (SceneElement sceneElement : sceneElements) {
            handle(sceneElement);
        }
    }

    private void handle(SceneElement sceneElement) {
        if (sceneElement instanceof Background) {
            background = (Background) sceneElement;
        } else if (sceneElement instanceof Camera) {
            camera = (Camera) sceneElement;
        } else if (sceneElement instanceof Light) {
            light = (Light) sceneElement;
        } else if (sceneElement instanceof Fog) {
            fog = (Fog) sceneElement;
        } else if (sceneElement instanceof Terrain) {
            addTerrain((Terrain) sceneElement);
        } else if (sceneElement instanceof Entity) {
            addEntity((Entity) sceneElement);
        } else if (sceneElement instanceof Entities) {
            Entities entities = (Entities) sceneElement;
            for (Entity[] entitiesArray : entities.getEntities()) {
                for (Entity entity : entitiesArray) {
                    addEntity(entity);
                }
            }
        }
    }

    public void addTerrain(Terrain terrain) {
        terrains.add(terrain);
    }

    public void addEntity(Entity entity) {
        if (!this.entities.containsKey(entity.shape)) {
            this.entities.put(entity.shape, new LinkedList<>());
        }
        this.entities.get(entity.shape).add(entity);
    }
}
