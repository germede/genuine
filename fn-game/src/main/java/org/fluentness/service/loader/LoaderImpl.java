package org.fluentness.service.loader;

import org.fluentness.service.memory.Memory;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;

public class LoaderImpl implements Loader {

    private Memory memory;
    private Parser parser;

    public LoaderImpl(Memory memory) {
        this.memory = memory;
    }

    @Override
    public int loadShape() {

        float[] vertices, float[] textures, float[] normals, int[] indices

        int vertexCount = indices.length;
        int vao = GL30.glGenVertexArrays();
        memory.vao(vao);

        GL30.glBindVertexArray(vao);
        int vbo = GL15.glGenBuffers();
        memory.vbo(vbo);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, memory.intBuffer(indices), GL15.GL_STATIC_DRAW);
        loadVbo(0, 3, vertices);
        loadVbo(1, 2, textures);
        loadVbo(2, 3, normals);
        GL30.glBindVertexArray(0);

        return vao;
    }

    private void loadVbo(int attributeNumber, int coordinateSize, float[] data) {
        int vbo = GL15.glGenBuffers();
        memory.vbo(vbo);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, memory.floatBuffer(data), GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(attributeNumber, coordinateSize, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    private int bindTexture(String path) {
        int result = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, result);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);


        int width, height;
        int[] pixels;
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/textures/" + path));
            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);

            int[] data = new int[width * height];
            for (int i = 0; i < width * height; i++) {
                int a = (pixels[i] & 0xff000000) >> 24;
                if (a > 0) {
                    hasTransparency = true;
                }
                int r = (pixels[i] & 0xff0000) >> 16;
                int g = (pixels[i] & 0xff00) >> 8;
                int b = (pixels[i] & 0xff);

                data[i] = a << 24 | b << 16 | g << 8 | r;
            }

            IntBuffer buffer = ByteBuffer.allocateDirect(data.length << 2)
                .order(ByteOrder.nativeOrder()).asIntBuffer();
            buffer.put(data).flip();

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
            glBindTexture(GL_TEXTURE_2D, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
