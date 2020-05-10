package org.fluentness.view;

import org.fluentness.service.algebra.DefaultAlgebra;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.model.shape.TerrainModel;
import org.fluentness.model.texture.TerrainTexture;

public class Terrain implements SceneElement {

    private final int vertexCount = 128;
    private final float size = 2200;
    private float repeatTextures = 40;

    private final TerrainModel model;
    private final TerrainTexture[] textures;

    private Vector3f translation;
    private Vector3f rotation = DefaultAlgebra.zeroVector3f();
    private float scale = 1;

    public Terrain(int gridX, int gridZ, TerrainTexture... textures) {
        translation = new Vector3f(gridX * size - size / 2, 0, gridZ * size - size / 2);

        model = new TerrainModel(vertexCount, size);
        this.textures = textures;
    }

    public float getRepeatTextures() {
        return repeatTextures;
    }

    public Terrain setRepeatTextures(float repeatTextures) {
        this.repeatTextures = repeatTextures;
        return this;
    }

    public TerrainModel getModel() {
        return model;
    }

    public TerrainTexture[] getTextures() {
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
}
