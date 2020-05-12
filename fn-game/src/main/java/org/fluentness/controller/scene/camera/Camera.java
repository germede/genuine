package org.fluentness.controller.scene.camera;

import org.fluentness.controller.scene.SceneElement;
import org.fluentness.controller.scene.entity.Entity;
import org.fluentness.service.algebra.Vector3f;

public class Camera implements SceneElement {

    public Vector3f translation;
    public Vector3f rotation = new Vector3f(0, 0, 0);

    public float aspect = 16f / 9f;
    public float fov = 70;
    public float near = 0.1f;
    public float far = 1000;

    public float translationSpeed = 200;
    public float rotationSpeed = 200;

    public float zoomSpeed = 10;
    public float zoom = 200;
    public float angle = 0;

    public Camera(float x, float y, float z) {
        this.translation = new Vector3f(x, y, z);
    }

    public void control(float delta, float upDown, float leftRight) {
        float distance = -this.translationSpeed * upDown * delta;
        translation.x += (float) (distance * Math.sin(Math.toRadians(-rotation.y)));
        translation.z += (float) (distance * Math.cos(Math.toRadians(-rotation.y)));
        rotation.y += this.rotationSpeed * leftRight * delta;
    }

    public void follow(Entity entity) {
        this.zoom += zoomSpeed * zoom;

        translation.x = entity.translation.x + (float)(this.zoom * Math.cos(Math.toRadians(entity.rotation.y)));
        translation.z = entity.translation.z + (float)(this.zoom * Math.sin(Math.toRadians(entity.rotation.y)));
        rotation.y= entity.rotation.y - 90;
    }
}
