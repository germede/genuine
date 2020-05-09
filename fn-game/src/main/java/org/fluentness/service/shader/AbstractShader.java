package org.fluentness.service.shader;

import org.fluentness.engine.algebra.Matrix4f;
import org.fluentness.engine.algebra.Vector3f;
import org.fluentness.engine.memory.BufferFactory;
import org.fluentness.engine.memory.Memory;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import java.io.*;
import java.nio.FloatBuffer;

public abstract class AbstractShader {


    private final int vertexShader = compile(getVertexShaderPath(), GL20.GL_VERTEX_SHADER);
    private final int fragmentShader = compile(getFragmentShaderPath(), GL20.GL_FRAGMENT_SHADER);
    private final int program = GL20.glCreateProgram();
    {
        GL20.glAttachShader(program, vertexShader);
        GL20.glAttachShader(program, fragmentShader);

        GL20.glLinkProgram(program);
        GL20.glValidateProgram(program);

        Memory.shader(this);
    }


    public final int transformationMatrix = getUniformLocation("transformationMatrix");
    public final int projectionMatrix = getUniformLocation("projectionMatrix");
    public final int viewMatrix = getUniformLocation("viewMatrix");
    public final int lightPosition = getUniformLocation("lightPosition");
    public final int lightColour = getUniformLocation("lightColour");
    public final int lightUniformly = getUniformLocation("lightUniformly");
    public final int ambientLight = getUniformLocation("ambientLight");
    public final int shineDamper = getUniformLocation("shineDamper");
    public final int reflectivity = getUniformLocation("reflectivity");
    public final int fogDensity = getUniformLocation("fogDensity");
    public final int fogGradient = getUniformLocation("fogGradient");
    public final int skyColour = getUniformLocation("skyColour");
    protected abstract String getVertexShaderPath();

    protected abstract String getFragmentShaderPath();

    protected int getUniformLocation(String transformationMatrix) {
        return GL20.glGetUniformLocation(program, transformationMatrix);
    }

    public int getVertexShader() {
        return vertexShader;
    }

    public int getFragmentShader() {
        return fragmentShader;
    }

    public int getProgram() {
        return program;
    }

    private int compile(String file, int type) {
        StringBuilder shaderSource = new StringBuilder();
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream("/shaders/" + file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line;
            while ((line = reader.readLine()) != null) {
                shaderSource.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        int shader = GL20.glCreateShader(type);
        GL20.glShaderSource(shader, shaderSource);
        GL20.glCompileShader(shader);
        if (GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            System.out.println(GL20.glGetShaderInfoLog(shader, 500));
            System.err.println("Could not compile shader");
            System.exit(-1);
        }
        return shader;
    }

    public void start() {
        GL20.glUseProgram(program);
    }

    public void stop() {
        GL20.glUseProgram(0);
    }

    public void set(int uniform, int value) {
        GL20.glUniform1i(uniform, value);
    }

    public void set(int uniform, float value) {
        GL20.glUniform1f(uniform, value);
    }

    public void set(int uniform, boolean value) {
        GL20.glUniform1f(uniform, value ? 1 : 0);
    }

    public void set(int uniform, Vector3f vector) {
        GL20.glUniform3f(uniform, vector.x, vector.y, vector.z);
    }

    public void set(int uniform, Matrix4f matrix) {
        FloatBuffer buffer = BufferFactory.matrix4fBuffer();
        matrix.toBuffer(buffer);
        GL20.glUniformMatrix4fv(uniform, false, buffer);
    }

}
