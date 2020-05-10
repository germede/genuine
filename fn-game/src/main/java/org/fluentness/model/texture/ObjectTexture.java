package org.fluentness.model.texture;

public class ObjectTexture extends AbstractTexture {

    private final boolean lightUniformly;

    public ObjectTexture(String texturePath) {
        super(texturePath);
        lightUniformly = hasTransparency; // todo make it light uniformly only when using multi-faced models
    }

    public boolean isLightUniformly() {
        return lightUniformly;
    }
}