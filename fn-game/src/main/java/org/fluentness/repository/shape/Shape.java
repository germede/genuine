package org.fluentness.repository.shape;

import org.fluentness.repository.CrudModel;

public class Shape implements CrudModel {

    private final int id;
    public final int vertexCount;

    public Shape(int id, int vertexCount) {
        this.id = id;
        this.vertexCount = vertexCount;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Not allowed to set shape id");
    }
}
