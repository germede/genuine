package org.fluentness.view.environment.background;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.view.environment.Environment;

public class Background implements Environment {

    public Vector3f colour;

    public Background(float r, float g, float b) {
        this.colour = new Vector3f(r,g,b);
    }

}
