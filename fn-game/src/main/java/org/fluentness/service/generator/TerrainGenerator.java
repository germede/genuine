package org.fluentness.service.generator;

import org.fluentness.repository.shape.RawShape;
import org.fluentness.repository.shape.Shape;
import org.fluentness.repository.texture.RawTexture;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.parser.TextureParser;

public class TerrainGenerator implements Generator {

    private final Loader loader;
    private final TextureParser textureParser;

    public TerrainGenerator(TextureParser textureParser, Loader loader) {
        this.textureParser = textureParser;
        this.loader = loader;
    }

    private static final float MAX_COLOUR = 256*256*256;
    private float size;
    private float maxHeight = 0;
    private RawTexture heightMap;
    private int vertexCount;

    @Override
    public Shape generate(float size, float maxHeight, String heightMapPath) {
        this.size = size;
        this.maxHeight = maxHeight;
        this.heightMap = textureParser.parse(heightMapPath);
        this.vertexCount = heightMap.getHeight();
        return generateShape();
    }

    @Override
    public Shape generate(float size, int vertexCount) {
        this.size = size;
        this.maxHeight = 0;
        this.heightMap = null;
        this.vertexCount = vertexCount;
        return generateShape();
    }

    private Shape generateShape() {
        int count = vertexCount * vertexCount;
        float[] vertices = new float[count * 3];
        float[] normals = new float[count * 3];
        float[] textures = new float[count * 2];
        int[] indices = new int[6 * (vertexCount - 1) * (vertexCount - 1)];
        int vertexPointer = 0;
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                vertices[vertexPointer * 3] = (float) j / ((float) vertexCount - 1) * size;
                vertices[vertexPointer * 3 + 1] = calculateHeight(j, i);
                vertices[vertexPointer * 3 + 2] = (float) i / ((float) vertexCount - 1) * size;
                Vector3f normal = calculateNormal(j, i);
                normals[vertexPointer * 3] = normal.x;
                normals[vertexPointer * 3 + 1] = normal.y;
                normals[vertexPointer * 3 + 2] = normal.z;
                textures[vertexPointer * 2] = (float) j / ((float) vertexCount - 1);
                textures[vertexPointer * 2 + 1] = (float) i / ((float) vertexCount - 1);
                vertexPointer++;
            }
        }
        int pointer = 0;
        for (int gz = 0; gz < vertexCount - 1; gz++) {
            for (int gx = 0; gx < vertexCount - 1; gx++) {
                int topLeft = (gz * vertexCount) + gx;
                int topRight = topLeft + 1;
                int bottomLeft = ((gz + 1) * vertexCount) + gx;
                int bottomRight = bottomLeft + 1;
                indices[pointer++] = topLeft;
                indices[pointer++] = bottomLeft;
                indices[pointer++] = topRight;
                indices[pointer++] = topRight;
                indices[pointer++] = bottomLeft;
                indices[pointer++] = bottomRight;
            }
        }
        return loader.loadShape(new RawShape(vertices, textures, normals, indices));
    }

    private float calculateHeight(int x, int z) {
        if (heightMap == null || x < 0 || x >= heightMap.getHeight() || z < 0 || z >= heightMap.getHeight()) {
            return 0;
        }
        float height = heightMap.getPixels()[z * heightMap.getWidth() + x];
        height += MAX_COLOUR / 2f;
        height /= MAX_COLOUR / 2f;
        height *= maxHeight;
        return height;
    }

    private Vector3f calculateNormal (int x, int z) {
        float heightLeft = calculateHeight(x-1,z);
        float heightRight = calculateHeight(x+1,z);
        float heightDown = calculateHeight(x,z-1);
        float heightUp = calculateHeight(x,z+1);
        return new Vector3f(heightLeft - heightRight, 2f, heightDown - heightUp).normalize();


    }
}
