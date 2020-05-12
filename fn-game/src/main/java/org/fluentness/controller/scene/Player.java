package org.fluentness.controller.scene;

import org.fluentness.repository.Shape;
import org.fluentness.repository.Texture;
import org.fluentness.service.algebra.Vector3f;

public class Player extends Entity {

    public Player(Shape shape, Texture texture) {
        super(shape, texture);
    }

    public Player(Shape shape, Texture texture, Vector3f translation, Vector3f rotation, float scale) {
        super(shape, texture, translation, rotation, scale);
    }


}
