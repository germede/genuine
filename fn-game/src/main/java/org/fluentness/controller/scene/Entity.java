package org.fluentness.controller.scene;

import org.fluentness.repository.Shape;
import org.fluentness.repository.Texture;
import org.fluentness.service.algebra.Vector3f;

public class Entity implements SceneElement {

    private Shape shape;
    private Texture texture;

    private Vector3f translation;
    private Vector3f rotation;
    private float scale;

    protected int translationStep = 200;
    protected int rotationStep = 200;

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

    public void move(float delta, boolean up, boolean left, boolean down, boolean right) {
        float translationSpeed;
        float rotationSpeed;

        if (down) translationSpeed = translationStep;
        else if (up) translationSpeed = -translationStep;
        else translationSpeed = 0;

        if (left) rotationSpeed = rotationStep;
        else if (right) rotationSpeed = -rotationStep;
        else rotationSpeed = 0;

        float distance = translationSpeed * delta;
        translation.x += (float) (distance * Math.sin(Math.toRadians(rotation.y)));
        translation.z += (float) (distance * Math.cos(Math.toRadians(rotation.y)));
        rotation.y += rotationSpeed * delta;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public int getTranslationStep() {
        return translationStep;
    }

    public void setTranslationStep(int translationStep) {
        this.translationStep = translationStep;
    }

    public int getRotationStep() {
        return rotationStep;
    }

    public void setRotationStep(int rotationStep) {
        this.rotationStep = rotationStep;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public void setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public void setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
    }
}
