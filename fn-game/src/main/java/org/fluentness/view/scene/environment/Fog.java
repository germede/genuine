package org.fluentness.view.scene.environment;

import org.fluentness.view.scene.SceneElement;

public class Fog implements SceneElement {

    public float density;
    public float gradient;

    public Fog(float density, float gradient) {
        this.density = density;
        this.gradient = gradient;
    }
}