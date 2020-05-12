package org.fluentness.controller.scene.light;

import org.fluentness.controller.scene.SceneElement;
import org.fluentness.service.algebra.Vector3f;

public class Light implements SceneElement {

    public Vector3f colour = new Vector3f(1,1,1);
    public float ambientLight = 0.5f;

    public Vector3f translation;

    public Light(float x, float y, float z) {
        this.translation = new Vector3f(x, y, z);
    }

}
