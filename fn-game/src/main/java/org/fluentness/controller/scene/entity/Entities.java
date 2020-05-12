package org.fluentness.controller.scene.entity;

import org.fluentness.controller.scene.SceneElement;

public class Entities implements SceneElement {

    private final Entity[][] entities;

    public Entities(Entity[][] entities) {
        this.entities = entities;
    }

    public Entity[][] getEntities() {
        return entities;
    }
}
