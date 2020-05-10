package org.fluentness.view.entity;

import org.fluentness.model.Shape;
import org.fluentness.service.algebra.DefaultAlgebra;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.model.shape.ShapeModel;
import org.fluentness.view.SceneElement;

public class Entity implements SceneElement {

    private Shape shape;

    private Vector3f translation = DefaultAlgebra.zeroVector3f();
    private Vector3f rotation =  DefaultAlgebra.zeroVector3f();
    private float scale = 1;

    private float shineDamper = 1;
    private float reflectivity = 0;

    public Entity(ShapeModel shape) {
        this.shape = shape;
    }

    public ShapeModel getShape() {
        return shape;
    }

    public Entity setShape(ShapeModel shape) {
        this.shape = shape;
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
