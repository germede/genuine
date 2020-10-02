package org.fluentness.service.shader;

import org.fluentness.service.memory.Memory;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class BaseShader implements Shader {

    private final int program = GL20.glCreateProgram();
    private final int vertexShader = compile(getVertexShaderPath(), GL20.GL_VERTEX_SHADER);
    private final int fragmentShader = compile(getFragmentShaderPath(), GL20.GL_FRAGMENT_SHADER);
    {
        GL20.glAttachShader(program, vertexShader);
        GL20.glAttachShader(program, fragmentShader);
        GL20.glLinkProgram(program);
        GL20.glValidateProgram(program);
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

    public BaseShader(Memory memory) {
        memory.shader(this);
        // display is not needed, just guarantee that shader is constructed after display
    }

    @Override
    public int getProgram() {
        return program;
    }

    public int getVertexShader() {
        return vertexShader;
    }

    public int getFragmentShader() {
        return fragmentShader;
    }

    protected abstract String getVertexShaderPath();

    protected abstract String getFragmentShaderPath();

    protected int getUniformLocation(String transformationMatrix) {
        return GL20.glGetUniformLocation(program, transformationMatrix);
    }

    protected int compile(String file, int type) {
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

}
