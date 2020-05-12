package org.fluentness.controller.scene.environment;

import org.fluentness.controller.scene.SceneElement;
import org.fluentness.service.algebra.Vector3f;

public class Background implements SceneElement {

    private Vector3f colour = new Vector3f(1,1,1);

    public Background(float r, float g, float b) {
        this.colour = new Vector3f(r,g,b);
    }

    public Vector3f getColour() {
        return colour;
    }

    public Background setColour(Vector3f colour) {
        this.colour = colour;
        return this;
    }
}
