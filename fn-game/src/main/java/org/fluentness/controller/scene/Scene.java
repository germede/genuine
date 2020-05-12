package org.fluentness.controller.scene;

import org.fluentness.controller.GameView;
import org.fluentness.controller.scene.camera.Camera;
import org.fluentness.controller.scene.entity.Entities;
import org.fluentness.controller.scene.entity.Entity;
import org.fluentness.controller.scene.environment.Background;
import org.fluentness.controller.scene.environment.Fog;
import org.fluentness.controller.scene.light.Light;
import org.fluentness.controller.scene.terrain.Terrain;
import org.fluentness.repository.Shape;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Scene implements GameView {

    private Background background;
    private Camera camera;
    private Light light;
    private Fog fog;
    private final List<Terrain> terrains = new LinkedList<>();
    private final Map<Shape, List<Entity>> entities = new HashMap<>();

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

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
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

    public void setFog(Fog fog) {
        this.fog = fog;
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void addTerrain(Terrain terrain) {
        terrains.add(terrain);
    }

    public Map<Shape, List<Entity>> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity) {
        if (!this.entities.containsKey(entity.getShape())) {
            this.entities.put(entity.getShape(), new LinkedList<>());
        }
        this.entities.get(entity.getShape()).add(entity);
    }
}
