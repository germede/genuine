package org.fluentness.engine.model;

import org.fluentness.engine.texture.ObjectTexture;

public class ObjectModel extends AbstractModel {

    private ObjectTexture texture;

    public ObjectModel(float[] vertices, float[] textures, float[] normals, int[] indices, ObjectTexture texture) {
        this.vertices = vertices;
        this.textures = textures;
        this.normals = normals;
        this.indices = indices;
        loadVao();
        this.texture = texture;
    }

    public ObjectTexture getTexture() {
        return texture;
    }

    public void setTexture(ObjectTexture texture) {
        this.texture = texture;
    }
}
