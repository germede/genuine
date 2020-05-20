package org.fluentness.model.texture;

import org.fluentness.model.Model;

public class Texture implements Model {

    private final int id;
    private final boolean hasTransparency;
    private final boolean lightUniformly;

    public Texture(int id, boolean hasTransparency) {
        this.id = id;
        this.hasTransparency = hasTransparency;
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

}
