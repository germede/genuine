package org.fluentness.model.texture;

import org.fluentness.model.Model;

public class RawTexture {

    private final int width;
    private final int height;
    private final int[] pixels;
    private final boolean hasTransparency;

    public RawTexture(int width, int height, int[] pixels, boolean hasTransparency) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
        this.hasTransparency = hasTransparency;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }

    public boolean hasTransparency() {
        return hasTransparency;
    }

}
