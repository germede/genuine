package org.fluentness.view.scene.entity;

import org.fluentness.view.scene.SceneElement;

public class Entities implements SceneElement {

    private final Entity[][] entities;

    public Entities(Entity[][] entities) {
        this.entities = entities;
    }

    public Entity[][] getEntities() {
        return entities;
    }
}
