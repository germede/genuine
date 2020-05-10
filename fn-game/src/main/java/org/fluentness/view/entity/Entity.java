package org.fluentness.view.entity;

import org.fluentness.model.Shape;
import org.fluentness.model.Texture;
import org.fluentness.service.algebra.Vector3f;

public class Entity {

    private Shape shape;
    private Texture texture;

    private Vector3f translation;
    private Vector3f rotation;
    private float scale;

    private float shineDamper = 1;
    private float reflectivity = 0;

    public Entity(Shape shape, Texture texture) {
        this.shape = shape;
        this.texture = texture;
        this.translation = new Vector3f(0, 0, 0);
        this.rotation = new Vector3f(0, 0, 0);
        this.scale = 1;
    }

    public Entity(Shape shape, Texture texture, Vector3f translation, Vector3f rotation, float scale) {
        this.shape = shape;
        this.texture = texture;
        this.translation = translation;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Shape getShape() {
        return shape;
    }

    public Entity setShape(Shape shape) {
        this.shape = shape;
        return this;
    }

    public Texture getTexture() {
        return texture;
    }

    public Entity setTexture(Texture texture) {
        this.texture = texture;
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
