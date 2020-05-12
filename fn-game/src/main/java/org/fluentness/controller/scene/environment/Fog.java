package org.fluentness.controller.scene.environment;

import org.fluentness.controller.scene.SceneElement;

public class Fog implements SceneElement {

    private float density;
    private float gradient;

    public Fog(float density, float gradient) {
        this.density = density;
        this.gradient = gradient;
    }

    public float getDensity() {
        return density;
    }

    public Fog setDensity(float density) {
        this.density = density;
        return this;
    }

    public float getGradient() {
        return gradient;
    }

    public Fog setGradient(float gradient) {
        this.gradient = gradient;
        return this;
    }
}