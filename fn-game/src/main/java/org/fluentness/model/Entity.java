package org.fluentness.model;

import org.fluentness.service.loader.Mesh;
import org.fluentness.service.loader.Texture;

public class Entity implements Model {

    public Mesh mesh;
    public Texture texture;

    public float x = 0, y = 0, z = 0;
    public float pitch = 0, yaw = 0, roll = 0;
    public float scale = 1;

    public float gravity = -250;
    public float jumpSpeed = 0;
    public float floor = 0;
    public boolean isJumping = false;

    public float shineDamper = 1;
    public float reflectivity = 0.5f;

    public Entity(Mesh mesh, Texture texture) {
        this.mesh = mesh;
        this.texture = texture;
    }

    public void control(float delta, float upDown, float leftRight, float jump) {
        float distance = upDown * delta;
        x += (float) (distance * Math.sin(Math.toRadians(yaw)));
        z += (float) (distance * Math.cos(Math.toRadians(yaw)));
        yaw += -leftRight * delta;

        if (jump > 0 && !isJumping) {
            jumpSpeed = 200;
            isJumping = true;
        }
        jumpSpeed += gravity * delta;
        y += jumpSpeed * delta;
        if (y <= floor) {
            jumpSpeed = 0;
            y = floor;
            isJumping = false;
        }

        pitch %= 360;
        yaw %= 360;
        roll %= 360;
    }
}
