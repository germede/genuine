package org.fluentness.view.scene.entity;

import org.fluentness.model.Shape;
import org.fluentness.model.Texture;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.view.scene.SceneElement;

public class Terrain implements SceneElement {

    private final Shape shape;
    private final Texture[] textures;

    private Vector3f translation;
    private Vector3f rotation;
    private float scale = 1;

    private float repeatTextures = 40;

    public Terrain(Shape shape, float size, int gridX, int gridZ, Texture... textures) {
        this.shape = shape;
        this.textures = textures;
        this.translation = new Vector3f(gridX * size - size / 2, 0, gridZ * size - size / 2);
        this.rotation = new Vector3f(0,0,0);
    }

    public Shape getShape() {
        return shape;
    }

    public Texture[] getTextures() {
        return textures;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public Terrain setTranslation(Vector3f translation) {
        this.translation = translation;
        return this;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Terrain setRotation(Vector3f rotation) {
        this.rotation = rotation;
        return this;
    }

    public float getScale() {
        return scale;
    }

    public Terrain setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public float getRepeatTextures() {
        return repeatTextures;
    }

    public Terrain setRepeatTextures(float repeatTextures) {
        this.repeatTextures = repeatTextures;
        return this;
    }
}
