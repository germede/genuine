package org.fluentness.service.memory;

import org.fluentness.service.shader.BaseShader;
import org.fluentness.service.shader.Shader;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.List;

public class MemoryImpl implements Memory {


    private final List<Integer> vaos = new LinkedList<>();
    private final List<Integer> vbos = new LinkedList<>();
    private final List<Integer> textures = new LinkedList<>();
    private final List<Shader> shaders = new LinkedList<>();

    @Override
    public void vao(int vao) {
        vaos.add(vao);
    }

    @Override
    public void vbo(int vbo) {
        vbos.add(vbo);
    }

    @Override
    public void texture(int texture) {
        textures.add(texture);
    }

    @Override
    public void shader(Shader shader) {
        shaders.add(shader);
    }

    @Override
    public void cleanUp() {
        for (int vao : vaos) {
            GL30.glDeleteVertexArrays(vao);
        }
        for (int vbo : vbos) {
            GL15.glDeleteBuffers(vbo);
        }
        for (int texture : textures) {
            GL11.glDeleteTextures(texture);
        }
        for (Shader shader : shaders) {
            shader.stop();
            if (shader instanceof BaseShader) {
                BaseShader baseShader = (BaseShader)shader;
                GL20.glDetachShader(shader.getProgram(), baseShader.getVertexShader());
                GL20.glDetachShader(shader.getProgram(), baseShader.getFragmentShader());
                GL20.glDeleteShader(baseShader.getVertexShader());
                GL20.glDeleteShader(baseShader.getFragmentShader());
            }
            GL20.glDeleteProgram(shader.getProgram());
        }
    }

    @Override
    public FloatBuffer floatBuffer(float... data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    @Override
    public IntBuffer intBuffer(int... data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

}
