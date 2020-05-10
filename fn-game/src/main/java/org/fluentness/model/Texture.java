package org.fluentness.model;

import org.fluentness.service.memory.DefaultMemory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Texture {

    private final int id;
    private final boolean hasTransparency = false;
    private final boolean lightUniformly;

    public Texture(int id, boolean hasTransparency) {
        id = load(texturePath);
        DefaultMemory.texture(id);
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
