package org.fluentness.controller.environment;

public class Fog {

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