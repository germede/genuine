package org.fluentness.model.environment;

import org.fluentness.model.Entity;

public class Camera {

    public float x, y, z;
    public float pitch = 20, yaw = 0, roll = 0;

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
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void control(float delta, float upDown, float leftRight) {
        float distance = -this.translationSpeed * upDown * delta;
        x += (float) (distance * Math.sin(Math.toRadians(-yaw)));
        z += (float) (distance * Math.cos(Math.toRadians(-yaw)));
        yaw += this.rotationSpeed * leftRight * delta;

        pitch %= 360;
        yaw %= 360;
        roll %= 360;
    }

    public void follow(Entity entity) {
        pitch = followPitch;
        float verticalDistance = (float) (this.zoom * Math.sin(Math.toRadians(pitch)));
        float horizontalDistance = (float) (this.zoom * Math.cos(Math.toRadians(pitch)));
        float offsetX = horizontalDistance * (float) Math.sin(Math.toRadians(entity.yaw + followYaw));
        float offsetZ = horizontalDistance * (float) Math.cos(Math.toRadians(entity.yaw + followYaw));
        x = entity.x - offsetX;
        y = entity.y + verticalDistance;
        z = entity.z - offsetZ;
        yaw = 180 - entity.yaw - followYaw;

        pitch %= 360;
        yaw %= 360;
        roll %= 360;
    }

}
