package org.fluentness.service.shader;

import org.fluentness.service.display.Display;
import org.fluentness.service.memory.Memory;

public class EntityShader extends AbstractShader {

    public EntityShader(Memory memory, Display display) {
        super(memory, display);
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
