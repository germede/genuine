package org.fluentness.model;

public class Shape implements Model {

    private final int vao;
    private final int vertexCount;

    public Shape(int vao, int vertexCount) {
        this.vao = vao;
        this.vertexCount = vertexCount;
    }

    public int getVao() {
        return vao;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    @Override
    public int getId() {
        return vao;
    }

    @Override
    public void setId(int id) {

    }
}
