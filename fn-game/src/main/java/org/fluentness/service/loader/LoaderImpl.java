package org.fluentness.service.loader;

import org.fluentness.service.parser.RawMesh;
import org.fluentness.service.parser.RawTexture;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.memory.Memory;
import org.fluentness.service.parser.MeshParser;
import org.fluentness.service.parser.TextureParser;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL14.GL_TEXTURE_LOD_BIAS;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

public class LoaderImpl implements Loader {

    private final Configuration configuration;
    private final Memory memory;
    private final MeshParser meshParser;
    private final TextureParser textureParser;

    public LoaderImpl(Configuration configuration, Memory memory, MeshParser meshParser, TextureParser textureParser) {
        this.configuration = configuration;
        this.memory = memory;
        this.meshParser = meshParser;
        this.textureParser = textureParser;
    }

    @Override
    public Mesh loadShape(String path) {
        return loadShape(meshParser.parse(path));
    }

    @Override
    public Mesh loadShape(RawMesh rawMesh) {

        // load vao
        int vertexCount = rawMesh.getIndices().length;
        int vao = GL30.glGenVertexArrays();
        memory.vao(vao);

        // load vbos
        GL30.glBindVertexArray(vao);
        int vbo = GL15.glGenBuffers();
        memory.vbo(vbo);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, memory.intBuffer(rawMesh.getIndices()), GL15.GL_STATIC_DRAW);
        loadVbo(0, 3, rawMesh.getVertices());
        loadVbo(1, 2, rawMesh.getTextures());
        loadVbo(2, 3, rawMesh.getNormals());
        GL30.glBindVertexArray(0);

        return new Mesh(vao, vertexCount);
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
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, rawTexture.getWidth(), rawTexture.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, rawTexture.getPixels());
        glGenerateMipmap(GL_TEXTURE_2D);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_LOD_BIAS, configuration.get(MIPMAP_BIAS));
        glBindTexture(GL_TEXTURE_2D, 0);

        return new Texture(texture, rawTexture);
    }
}
