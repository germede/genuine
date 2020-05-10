package org.fluentness.view.entity;

import org.fluentness.model.Shape;
import org.fluentness.model.Texture;
import org.fluentness.service.algebra.Vector3f;

public class Player extends Entity {

    private float runSpeed = 20;
    private float turnSpeed = 20;

    private float currentRunSpeed = 0;
    private float currentTurnSpeed = 0;


    public Player(Shape shape, Texture texture) {
        super(shape, texture);
    }

    public Player(Shape shape, Texture texture, Vector3f translation, Vector3f rotation, float scale) {
        super(shape, texture, translation, rotation, scale);
    }

    public float getRunSpeed() {
        return runSpeed;
    }

    public Player setRunSpeed(float runSpeed) {
        this.runSpeed = runSpeed;
        return this;
    }

    public float getTurnSpeed() {
        return turnSpeed;
    }

    public Player setTurnSpeed(float turnSpeed) {
        this.turnSpeed = turnSpeed;
        return this;
    }
}
