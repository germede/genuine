package org.fluentness.service.loader;

import org.fluentness.repository.Shape;
import org.fluentness.repository.Texture;
import org.fluentness.service.memory.Memory;
import org.fluentness.repository.RawShape;
import org.fluentness.repository.RawTexture;
import org.fluentness.service.parser.ShapeParser;
import org.fluentness.service.parser.TextureParser;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import static org.lwjgl.opengl.GL11.*;

public class DefaultLoader implements Loader {

    private final Memory memory;
    private final ShapeParser shapeParser;
    private final TextureParser textureParser;

    public DefaultLoader(Memory memory, ShapeParser shapeParser, TextureParser textureParser) {
        this.memory = memory;
        this.shapeParser = shapeParser;
        this.textureParser = textureParser;
    }

    @Override
    public Shape loadShape(String path) {
        return loadShape(shapeParser.parse(path));
    }

    @Override
    public Shape loadShape(RawShape rawShape) {

        // load vao
        int vertexCount = rawShape.getIndices().length;
        int vao = GL30.glGenVertexArrays();
        memory.vao(vao);

        // load vbos
        GL30.glBindVertexArray(vao);
        int vbo = GL15.glGenBuffers();
        memory.vbo(vbo);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, memory.intBuffer(rawShape.getIndices()), GL15.GL_STATIC_DRAW);
        loadVbo(0, 3, rawShape.getVertices());
        loadVbo(1, 2, rawShape.getTextures());
        loadVbo(2, 3, rawShape.getNormals());
        GL30.glBindVertexArray(0);

        return new Shape(vao, vertexCount);
    }

    private void loadVbo(int attributeNumber, int coordinateSize, float[] data) {
        int vbo = GL15.glGenBuffers();
        memory.vbo(vbo);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, memory.floatBuffer(data), GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(attributeNumber, coordinateSize, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    @Override
    public Texture loadTexture(String path) {
        RawTexture rawTexture = textureParser.parse(path);

        int texture = glGenTextures();
        memory.texture(texture);

        glBindTexture(GL_TEXTURE_2D, texture);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, rawTexture.getWidth(), rawTexture.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, rawTexture.getPixels());
        glBindTexture(GL_TEXTURE_2D, 0);

        return new Texture(texture, rawTexture.hasTransparency());
    }
}
