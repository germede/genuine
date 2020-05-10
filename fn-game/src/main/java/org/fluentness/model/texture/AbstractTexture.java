package org.fluentness.model.texture;

import org.fluentness.service.memory.DefaultMemory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;

public abstract class AbstractTexture {

    protected final int id;
    protected boolean hasTransparency = false;

    public AbstractTexture(String texturePath) {
        id = load(texturePath);
        DefaultMemory.texture(id);
    }

    public int getId() {
        return id;
    }

    public boolean hasTransparency() {
        return hasTransparency;
    }

    private int load(String path) {
        int result = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, result);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);


        int width, height;
        int[] pixels;
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/textures/" + path));
            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);

            int[] data = new int[width * height];
            for (int i = 0; i < width * height; i++) {
                int a = (pixels[i] & 0xff000000) >> 24;
                if (a > 0) {
                    hasTransparency = true;
                }
                int r = (pixels[i] & 0xff0000) >> 16;
                int g = (pixels[i] & 0xff00) >> 8;
                int b = (pixels[i] & 0xff);

                data[i] = a << 24 | b << 16 | g << 8 | r;
            }

            IntBuffer buffer = ByteBuffer.allocateDirect(data.length << 2)
                .order(ByteOrder.nativeOrder()).asIntBuffer();
            buffer.put(data).flip();

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
            glBindTexture(GL_TEXTURE_2D, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
