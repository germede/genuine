package org.fluentness.controller.scene.camera;

import org.fluentness.controller.scene.SceneElement;
import org.fluentness.service.algebra.Vector3f;

public class Camera implements SceneElement {

    private Vector3f translation;
    private Vector3f rotation = new Vector3f(0,0,0);

    private  float aspect = 16f / 9f;
    private  float fov = 70;
    private  float near = 0.1f;
    private  float far = 1000;

    protected int translationStep = 200;
    protected int rotationStep = 200;

    public Camera(float x, float y, float z) {
        this.translation = new Vector3f(x,y,z);
    }

    public void move(float delta, boolean up, boolean left, boolean down, boolean right) {
        float translationSpeed;
        float rotationSpeed;

        if (down) translationSpeed = translationStep;
        else if (up) translationSpeed = -translationStep;
        else translationSpeed = 0;

        if (right) rotationSpeed = rotationStep;
        else if (left) rotationSpeed = -rotationStep;
        else rotationSpeed = 0;

        float distance = translationSpeed * delta;
        translation.x += (float) (distance * Math.sin(Math.toRadians(-rotation.y)));
        translation.z += (float) (distance * Math.cos(Math.toRadians(-rotation.y)));
        rotation.y += rotationSpeed * delta;
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

    public float getAspect() {
        return aspect;
    }

    public void setAspect(float aspect) {
        this.aspect = aspect;
    }

    public float getFov() {
        return fov;
    }

    public void setFov(float fov) {
        this.fov = fov;
    }

    public float getNear() {
        return near;
    }

    public void setNear(float near) {
        this.near = near;
    }

    public float getFar() {
        return far;
    }

    public void setFar(float far) {
        this.far = far;
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
}
