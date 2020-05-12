package org.fluentness.controller.scene;

public class Entities implements SceneElement {

    private final Entity[][] entities;

    public Entities(Entity[][] entities) {
        this.entities = entities;
    }

    public Entity[][] getEntities() {
        return entities;
    }
}
