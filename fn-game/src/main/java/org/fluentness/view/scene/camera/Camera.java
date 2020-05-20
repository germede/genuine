package org.fluentness.view.scene.camera;

import org.fluentness.view.scene.SceneElement;
import org.fluentness.view.scene.entity.Entity;
import org.fluentness.service.algebra.Vector3f;

public class Camera implements SceneElement {

    public Vector3f translation;
    public Vector3f rotation = new Vector3f(20, 0, 0);

    public float aspect = 16f / 9f;
    public float fov = 70;
    public float near = 0.1f;
    public float far = 1000;

    public float translationSpeed = 200;
    public float rotationSpeed = 200;

    public float zoom = 200;
    public float followPitch = 0;
    public float followYaw = 0;

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
        rotation.x = followPitch;
        float verticalDistance = (float) (this.zoom * Math.sin(Math.toRadians(rotation.x)));
        float horizontalDistance = (float) (this.zoom * Math.cos(Math.toRadians(rotation.x)));
        float offsetX = horizontalDistance * (float) Math.sin(Math.toRadians(entity.rotation.y + followYaw));
        float offsetZ = horizontalDistance * (float) Math.cos(Math.toRadians(entity.rotation.y + followYaw));
        translation.x = entity.translation.x - offsetX;
        translation.y = entity.translation.y + verticalDistance;
        translation.z = entity.translation.z - offsetZ;
        rotation.y = 180 - entity.rotation.y - followYaw;
    }
}
