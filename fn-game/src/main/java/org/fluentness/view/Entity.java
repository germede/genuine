package org.fluentness.view;

import org.fluentness.service.algebra.DefaultAlgebra;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.model.shape.ShapeModel;

public class Entity implements SceneElement {

    private ShapeModel model;

    private Vector3f translation = DefaultAlgebra.zeroVector3f();
    private Vector3f rotation =  DefaultAlgebra.zeroVector3f();
    private float scale = 1;

    private float shineDamper = 1;
    private float reflectivity = 0;

    public Entity(ShapeModel model) {
        this.model = model;
    }

    public ShapeModel getModel() {
        return model;
    }

    public Entity setModel(ShapeModel model) {
        this.model = model;
        return this;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public Entity setTranslation(Vector3f translation) {
        this.translation = translation;
        return this;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Entity setRotation(Vector3f rotation) {
        this.rotation = rotation;
        return this;
    }

    public float getScale() {
        return scale;
    }

    public Entity setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public Entity setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
        return this;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public Entity setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
        return this;
    }
}
