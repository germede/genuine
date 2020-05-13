package org.fluentness.controller.lwjgl.terrain;

import org.fluentness.controller.lwjgl.SceneElement;
import org.fluentness.repository.shape.Shape;
import org.fluentness.repository.texture.Texture;
import org.fluentness.service.algebra.Vector3f;

public class Terrain implements SceneElement {

    public final Shape shape;
    public final Texture[] textures;

    public Vector3f translation;
    public Vector3f rotation;
    public float scale = 1;

    public float repeatTextures = 40;

    public Terrain(Shape shape, float size, int gridX, int gridZ, Texture... textures) {
        this.shape = shape;
        this.textures = textures;
        this.translation = new Vector3f(gridX * size - size / 2, 0, gridZ * size - size / 2);
        this.rotation = new Vector3f(0,0,0);
    }
}
