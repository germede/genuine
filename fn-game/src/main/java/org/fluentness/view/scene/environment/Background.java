package org.fluentness.view.scene.environment;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.view.scene.SceneElement;

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
