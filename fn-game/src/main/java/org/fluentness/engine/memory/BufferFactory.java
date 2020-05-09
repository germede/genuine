package org.fluentness.engine.memory;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class BufferFactory {

    private static final FloatBuffer MATRIX_4F_BUFFER = BufferUtils.createFloatBuffer(16);

    private BufferFactory() {
    }

    public static FloatBuffer floatBuffer(float... data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    public static IntBuffer intBuffer(int... data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    public static FloatBuffer matrix4fBuffer() {
        return MATRIX_4F_BUFFER;
    }
}
