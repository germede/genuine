package org.fluentness.repository;

import org.fluentness.repository.Model;

public class Shape implements Model {

    private final int id;
    private final int vertexCount;

    public Shape(int id, int vertexCount) {
        this.id = id;
        this.vertexCount = vertexCount;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not allowed to set shape id");
    }
}
