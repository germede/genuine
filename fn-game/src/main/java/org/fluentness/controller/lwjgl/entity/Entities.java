package org.fluentness.controller.lwjgl.entity;

import org.fluentness.controller.lwjgl.SceneElement;

public class Entities implements SceneElement {

    private final Entity[][] entities;

    public Entities(Entity[][] entities) {
        this.entities = entities;
    }

    public Entity[][] getEntities() {
        return entities;
    }
}
