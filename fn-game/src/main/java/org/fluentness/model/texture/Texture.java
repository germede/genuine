package org.fluentness.model.texture;

public class Texture {

    private final int id;
    private final RawTexture rawTexture;
    private final boolean hasTransparency;
    private final boolean lightUniformly;

    public Texture(int id, RawTexture rawTexture) {
        this.id = id;
        this.hasTransparency = rawTexture.hasTransparency();
        this.rawTexture = rawTexture;
        lightUniformly = hasTransparency; // todo make it light uniformly only when using multi-faced models
    }

    public int getId() {
        return id;
    }

    public boolean hasTransparency() {
        return hasTransparency;
    }

    public boolean isLightUniformly() {
        return lightUniformly;
    }

    public RawTexture getRawTexture() {
        return rawTexture;
    }
}
