package org.fluentness.engine.entity;

import org.fluentness.engine.algebra.Vector3f;
import org.fluentness.engine.algebra.VectorFactory;

public class Light implements Entity {

    private Vector3f translation = VectorFactory.zeroVector3f();
    private Vector3f colour = VectorFactory.whiteRgb();
    private float ambientLight = 0.5f;

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
