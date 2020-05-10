package org.fluentness.service.shader;

public class EntityShader extends AbstractShader {

    @Override
    protected String getVertexShaderPath() {
        return "objectVertexShader.txt";
    }

    @Override
    protected String getFragmentShaderPath() {
        return "objectFragmentShader.txt";
    }
}
