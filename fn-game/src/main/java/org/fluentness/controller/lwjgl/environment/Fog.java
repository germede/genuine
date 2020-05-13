package org.fluentness.controller.lwjgl.environment;

import org.fluentness.controller.lwjgl.SceneElement;

public class Fog implements SceneElement {

    public float density;
    public float gradient;

    public Fog(float density, float gradient) {
        this.density = density;
        this.gradient = gradient;
    }
}