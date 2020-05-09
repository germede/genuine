package org.fluentness.engine.entity;

import org.fluentness.engine.algebra.Vector3f;
import org.fluentness.engine.algebra.VectorFactory;
import org.fluentness.engine.model.ObjectModel;

public class Object implements Entity {

    private ObjectModel model;

    private Vector3f translation = VectorFactory.zeroVector3f();
    private Vector3f rotation =  VectorFactory.zeroVector3f();
    private float scale = 1;

    private float shineDamper = 1;
    private float reflectivity = 0;

    public Object(ObjectModel model) {
        this.model = model;
    }

    public ObjectModel getModel() {
        return model;
    }

    public Object setModel(ObjectModel model) {
        this.model = model;
        return this;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public Object setTranslation(Vector3f translation) {
        this.translation = translation;
        return this;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Object setRotation(Vector3f rotation) {
        this.rotation = rotation;
        return this;
    }

    public float getScale() {
        return scale;
    }

    public Object setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public Object setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
        return this;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public Object setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
        return this;
    }
}
