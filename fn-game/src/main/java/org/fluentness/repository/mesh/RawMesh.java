package org.fluentness.repository.mesh;

import org.fluentness.repository.Model;

public class RawMesh implements Model {

    private final float[] vertices;
    private final float[] textures;
    private final float[] normals;
    private final int[] indices;

    public RawMesh(float[] vertices, float[] textures, float[] normals, int[] indices) {
        this.vertices = vertices;
        this.textures = textures;
        this.normals = normals;
        this.indices = indices;
    }

    public float[] getVertices() {
        return vertices;
    }

    public float[] getTextures() {
        return textures;
    }

    public float[] getNormals() {
        return normals;
    }

    public int[] getIndices() {
        return indices;
    }
}
