package org.fluentness.view;

import org.fluentness.service.algebra.DefaultAlgebra;
import org.fluentness.service.algebra.Vector3f;

public class Light implements SceneElement {

    private Vector3f translation = DefaultAlgebra.zeroVector3f();
    private Vector3f colour = DefaultAlgebra.whiteRgb();
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
