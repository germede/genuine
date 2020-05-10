package org.fluentness.view.environment;

import org.fluentness.service.algebra.Vector3f;

public class Light {

    private Vector3f colour = new Vector3f(1,1,1);
    private float ambientLight = 0.5f;

    private Vector3f translation;

    public Light(float x, float y, float z) {
        this.translation = new Vector3f(x, y, z);
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public Light setTranslation(Vector3f translation) {
        this.translation = translation;
        return this;
    }

    public Vector3f getColour() {
        return colour;
    }

    public Light setColour(Vector3f colour) {
        this.colour = colour;
        return this;
    }

    public float getAmbientLight() {
        return ambientLight;
    }

    public Light setAmbientLight(float ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }
}
