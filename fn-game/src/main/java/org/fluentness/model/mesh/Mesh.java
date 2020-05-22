package org.fluentness.model.mesh;

import org.fluentness.model.Model;

public class Mesh {

    private final int id;
    public final int vertexCount;

    public Mesh(int id, int vertexCount) {
        this.id = id;
        this.vertexCount = vertexCount;
    }

    public int getId() {
        return id;
    }

}
