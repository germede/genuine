package org.fluentness.service.memory;

import org.fluentness.service.Service;
import org.fluentness.service.shader.Shader;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface Memory extends Service {
    void vao(int vao);

    void vbo(int vbo);

    void texture(int texture);

    void shader(Shader shader);

    void cleanUp();

    FloatBuffer floatBuffer(float... data);

    IntBuffer intBuffer(int... data);

    FloatBuffer matrix4fBuffer();
}
