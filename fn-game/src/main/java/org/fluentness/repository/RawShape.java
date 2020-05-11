package org.fluentness.repository;

public class RawShape {

    private final float[] vertices;
    private final float[] textures;
    private final float[] normals;
    private final int[] indices;

    public RawShape(float[] vertices, float[] textures, float[] normals, int[] indices) {
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
