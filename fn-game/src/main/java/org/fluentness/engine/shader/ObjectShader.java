package org.fluentness.engine.shader;

public class ObjectShader extends AbstractShader {

    @Override
    protected String getVertexShaderPath() {
        return "objectVertexShader.txt";
    }

    @Override
    protected String getFragmentShaderPath() {
        return "objectFragmentShader.txt";
    }
}
