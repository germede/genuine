package org.fluentness.service.memory;

import org.fluentness.service.shader.AbstractShader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.util.LinkedList;
import java.util.List;

public final class Memory {

    private Memory() {

    }

    private static final List<Integer> vaos = new LinkedList<>();
    private static final List<Integer> vbos = new LinkedList<>();
    private static final List<Integer> textures = new LinkedList<>();
    private static final List<AbstractShader> shaders = new LinkedList<AbstractShader>();

    public static void vao(int vao) {
        vaos.add(vao);
    }

    public static void vbo(int vbo) {
        vbos.add(vbo);
    }

    public static void texture(int texture) {
        textures.add(texture);
    }

    public static void shader(AbstractShader shader) {
        shaders.add(shader);
    }

    public static void cleanUp() {
        for (int vao : vaos) {
            GL30.glDeleteVertexArrays(vao);
        }
        for (int vbo : vbos) {
            GL15.glDeleteBuffers(vbo);
        }
        for (int texture : textures) {
            GL11.glDeleteTextures(texture);
        }
        for (AbstractShader shader: shaders) {
            shader.stop();
            GL20.glDetachShader(shader.getProgram(), shader.getVertexShader());
            GL20.glDetachShader(shader.getProgram(), shader.getFragmentShader());
            GL20.glDeleteShader(shader.getVertexShader());
            GL20.glDeleteShader(shader.getFragmentShader());
            GL20.glDeleteProgram(shader.getProgram());
        }
    }
}
