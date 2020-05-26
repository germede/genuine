package org.fluentness.view.scene.entity;

import org.fluentness.view.scene.SceneElement;
import org.fluentness.model.mesh.Mesh;
import org.fluentness.model.texture.Texture;
import org.fluentness.model.algebra.Vector3f;

public class Entity implements SceneElement {

    public Mesh mesh;
    public Texture texture;

    public Vector3f translation;
    public Vector3f rotation;
    public float scale;

    public float gravity = -250;
    public float jumpSpeed = 0;
    public float floor = 0;
    public boolean isJumping = false;

    public float shineDamper = 1;
    public float reflectivity = 0.5f;

    public Entity(Mesh mesh, Texture texture) {
        this.mesh = mesh;
        this.texture = texture;
        this.translation = new Vector3f(0, 0, 0);
        this.rotation = new Vector3f(0, 0, 0);
        this.scale = 1;
    }

    public void control(float delta, float upDown, float leftRight, float jump) {
        float distance = upDown * delta;
        translation.x += (float) (distance * Math.sin(Math.toRadians(rotation.y)));
        translation.z += (float) (distance * Math.cos(Math.toRadians(rotation.y)));
        rotation.y += -leftRight * delta;

        if (jump > 0 && !isJumping) {
            jumpSpeed = 200;
            isJumping = true;
        }
        jumpSpeed += gravity * delta;
        translation.y += jumpSpeed * delta;
        if (translation.y <= floor) {
            jumpSpeed = 0;
            translation.y = floor;
            isJumping = false;
        }

        rotation.x = rotation.x % 360;
        rotation.y = rotation.y % 360;
        rotation.z = rotation.z % 360;
    }

}
