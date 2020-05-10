package org.fluentness.view;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.algebra.VectorFactory;

public class Camera implements SceneElement {

    private Vector3f translation = VectorFactory.zeroVector3f();
    private Vector3f rotation = VectorFactory.zeroVector3f();

    private  float aspect = 16f / 9f;
    private  float fov = 70;
    private  float near = 0.1f;
    private  float far = 1000;

    public Vector3f getTranslation() {
        return translation;
    }

    public Camera setTranslation(Vector3f translation) {
        this.translation = translation;
        return this;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Camera setRotation(Vector3f rotation) {
        this.rotation = rotation;
        return this;
    }

    public float getAspect() {
        return aspect;
    }

    public Camera setAspect(float aspect) {
        this.aspect = aspect;
        return this;
    }

    public float getFov() {
        return fov;
    }

    public Camera setFov(float fov) {
        this.fov = fov;
        return this;
    }

    public float getNear() {
        return near;
    }

    public Camera setNear(float near) {
        this.near = near;
        return this;
    }

    public float getFar() {
        return far;
    }

    public Camera setFar(float far) {
        this.far = far;
        return this;
    }
}
