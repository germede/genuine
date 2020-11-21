package org.fluentness.view;

import org.fluentness.model.Entity;
import org.fluentness.model.Terrain;
import org.fluentness.model.Background;
import org.fluentness.model.Camera;
import org.fluentness.model.Fog;
import org.fluentness.model.Light;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractGameView implements View {

    protected final CharSequence title;
    public final Background background = background();
    public final Camera camera = camera();
    public final Light light = light();
    public final Fog fog = fog();
    public final List<Terrain> terrains = new LinkedList<>();
    public final Map<String, List<Entity>> entities = new HashMap<>();

    public AbstractGameView(CharSequence title) {
        this.title = title;
    }

    @Override
    public CharSequence getTitle() {
        return title;
    }

    public Map<String, List<Entity>> getEntities() {
        return entities;
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    protected void addEntity(Entity entity) {
        String key = entity.mesh.getId() + "-" + entity.texture.getId();
        if (!this.entities.containsKey(key)) {
            this.entities.put(key, new LinkedList<>());
        }
        this.entities.get(key).add(entity);
    }

    protected void addTerrain(Terrain terrain) {
        terrains.add(terrain);
    }

    protected abstract Background background();

    protected abstract Camera camera();

    protected abstract Light light();

    protected abstract Fog fog();

}
