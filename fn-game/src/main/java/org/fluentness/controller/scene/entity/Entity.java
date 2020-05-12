package org.fluentness.controller.scene.entity;

import org.fluentness.controller.scene.Scene;
import org.fluentness.controller.scene.SceneElement;
import org.fluentness.repository.Shape;
import org.fluentness.repository.Texture;
import org.fluentness.service.algebra.Vector3f;

public class Entity implements SceneElement {

    private Scene scene;

    private Shape shape;
    private Texture texture;

    private Vector3f translation;
    private Vector3f rotation;
    private float scale;

    private int translationSpeed = 200;
    private int rotationSpeed = 200;

    private int jumpPower = 100;
    private int gravity = -250;
    private boolean isJumping = false;
    private int jumpSpeed = 0;

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

    public void control(float delta, boolean up, boolean left, boolean down, boolean right, boolean jump) {
        float translationSpeed;
        float rotationSpeed;

        if (down) translationSpeed = this.translationSpeed;
        else if (up) translationSpeed = -this.translationSpeed;
        else translationSpeed = 0;
        float distance = translationSpeed * delta;
        translation.x += (float) (distance * Math.sin(Math.toRadians(rotation.y)));
        translation.z += (float) (distance * Math.cos(Math.toRadians(rotation.y)));

        if (left) rotationSpeed = this.rotationSpeed;
        else if (right) rotationSpeed = -this.rotationSpeed;
        else rotationSpeed = 0;
        rotation.y += rotationSpeed * delta;

        if (jump && !isJumping) {
            jumpSpeed = jumpPower;
            isJumping = true;
        }
        jumpSpeed += gravity * delta;
        translation.y += jumpSpeed * delta;
        if (translation.y <= 0) {
            jumpSpeed = 0;
            translation.y = 0;
            isJumping = false;
        }
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

    public int getTranslationSpeed() {
        return translationSpeed;
    }

    public void setTranslationSpeed(int translationSpeed) {
        this.translationSpeed = translationSpeed;
    }

    public int getJumpPower() {
        return jumpPower;
    }

    public void setJumpPower(int jumpPower) {
        this.jumpPower = jumpPower;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
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
