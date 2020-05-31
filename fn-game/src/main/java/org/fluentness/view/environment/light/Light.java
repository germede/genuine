package org.fluentness.view.environment.light;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.view.environment.Environment;

public class Light implements Environment {

    public Vector3f colour = new Vector3f(1,1,1);
    public float ambientLight = 1f;

    public Vector3f translation;

    public Light(float x, float y, float z) {
        this.translation = new Vector3f(x, y, z);
    }

}
