package org.fluentness.view.scene;

import org.fluentness.model.mesh.Mesh;
import org.fluentness.model.texture.Texture;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.Layout;
import org.fluentness.view.scene.camera.Camera;
import org.fluentness.view.scene.entity.Entities;
import org.fluentness.view.scene.entity.Entity;
import org.fluentness.view.scene.environment.Background;
import org.fluentness.view.scene.environment.Fog;
import org.fluentness.view.scene.light.Light;
import org.fluentness.view.scene.terrain.Terrain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Scene implements Layout {

    public Background background;
    public Camera camera;
    public Light light;
    public Fog fog;
    public final List<Terrain> terrains = new LinkedList<>();
    public final Map<String, List<Entity>> entities = new HashMap<>();

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
        String key = getMapKey(entity.mesh, entity.texture);
        if (!this.entities.containsKey(key)) {
            this.entities.put(key, new LinkedList<>());
        }
        this.entities.get(key).add(entity);
    }

    private String getMapKey(Mesh mesh, Texture texture) {
        return mesh.getId() + "-" + texture.getId();
    }

    @Override
    public void add(Component component) {

    }
}
