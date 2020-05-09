package org.fluentness.engine.model;

import org.fluentness.engine.memory.BufferFactory;
import org.fluentness.engine.memory.Memory;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public abstract class AbstractModel {

    private int vao;
    private int vertexCount;

    protected float[] vertices;
    protected float[] textures;
    protected float[] normals;
    protected int[] indices;

    protected void loadVao() {
        vertexCount = indices.length;
        vao = GL30.glGenVertexArrays();
        Memory.vao(vao);

        GL30.glBindVertexArray(vao);
        int vbo = GL15.glGenBuffers();
        Memory.vbo(vbo);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, BufferFactory.intBuffer(indices), GL15.GL_STATIC_DRAW);
        loadVBO(0, 3, vertices);
        loadVBO(1, 2, textures);
        loadVBO(2, 3, normals);
        GL30.glBindVertexArray(0);
    }

    private void loadVBO(int attributeNumber, int coordinateSize, float[] data) {
        int vbo = GL15.glGenBuffers();
        Memory.vbo(vbo);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, BufferFactory.floatBuffer(data), GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(attributeNumber, coordinateSize, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    public int getVao() {
        return vao;
    }

    public int getVertexCount() {
        return vertexCount;
    }

}
