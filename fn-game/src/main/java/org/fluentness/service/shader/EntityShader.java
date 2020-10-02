package org.fluentness.service.shader;

import org.fluentness.service.memory.Memory;

public class EntityShader extends BaseShader {

    public EntityShader(Memory memory) {
        super(memory);
    }

    @Override
    protected String getVertexShaderPath() {
        return "objectVertexShader.txt";
    }

    @Override
    protected String getFragmentShaderPath() {
        return "objectFragmentShader.txt";
    }
}
