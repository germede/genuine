package org.fluentness.model;

public class Light {

    public float x, y, z;

    public float r = 1, g = 1, b = 1;
    public float ambientLight = 1;

    public Light(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
