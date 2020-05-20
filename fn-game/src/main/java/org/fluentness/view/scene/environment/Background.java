package org.fluentness.view.scene.environment;

import org.fluentness.view.scene.SceneElement;
import org.fluentness.service.algebra.Vector3f;

public class Background implements SceneElement {

    public Vector3f colour;

    public Background(float r, float g, float b) {
        this.colour = new Vector3f(r,g,b);
    }

}
