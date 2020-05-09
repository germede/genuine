package org.fluentness.engine.entity;

public class Fog implements Entity {

    private float density = 0.0012f;
    private float gradient = 5.0f;

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