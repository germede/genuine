package org.fluentness.service.parser;

import org.fluentness.repository.texture.RawTexture;
import org.fluentness.service.log.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class TextureParser implements Parser<RawTexture> {

    private final Log log;

    public TextureParser(Log log) {
        this.log = log;
    }

    @Override
    public RawTexture parse(String path) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/textures/" + path));
            boolean hasTransparency = false;
            int width = image.getWidth();
            int height = image.getHeight();
            int[] rawPixels = new int[width * height];
            image.getRGB(0, 0, width, height, rawPixels, 0, width);
            int[] pixels = new int[width * height];
            for (int i = 0; i < width * height; i++) {
                int a = (rawPixels[i] & 0xff000000) >> 24;
                if (a > 0) {
                    hasTransparency = true;
                }
                int r = (rawPixels[i] & 0xff0000) >> 16;
                int g = (rawPixels[i] & 0xff00) >> 8;
                int b = (rawPixels[i] & 0xff);

                pixels[i] = a << 24 | b << 16 | g << 8 | r;
            }
            IntBuffer pixelss = ByteBuffer.allocateDirect(pixels.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
            pixelss.put(pixels).flip();
            return new RawTexture(width, height, pixels, hasTransparency);
        } catch (IOException e) {
            log.error(e);
            System.exit(-1);
        }
        return null;
    }

}
