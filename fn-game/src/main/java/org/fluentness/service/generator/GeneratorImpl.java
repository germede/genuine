package org.fluentness.service.generator;

import org.fluentness.controller.scene.terrain.Terrain;
import org.fluentness.repository.mesh.RawMesh;
import org.fluentness.repository.texture.RawTexture;
import org.fluentness.repository.texture.Texture;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.parser.TextureParser;

public class GeneratorImpl implements Generator {

    private final Loader loader;
    private final TextureParser textureParser;

    public GeneratorImpl(TextureParser textureParser, Loader loader) {
        this.textureParser = textureParser;
        this.loader = loader;
    }


    private static final float MAX_COLOUR = 256 * 256 * 256;
    private float[][] heights;

    @Override
    public Terrain generate(int gridX, int gridZ, float size, float maxHeight, String heightMapPath, String... texturePaths) {
        RawTexture heightMap = textureParser.parse(heightMapPath);
        RawMesh rawMesh = generateMesh(size, maxHeight, heightMap);
        Texture[] textures = new Texture[texturePaths.length];
        for (int i = 0; i < texturePaths.length; i++) {
            textures[i] = loader.loadTexture(texturePaths[i]);
        }
        Terrain terrain = new Terrain(size, heights, loader.loadShape(rawMesh), textures);
        terrain.translation = new Vector3f(gridX * size - size / 2, 0, gridZ * size - size / 2);
        return terrain;
    }

    private RawMesh generateMesh(float size, float maxHeight, RawTexture heightMap) {
        int vertexCount = heightMap.getHeight();
        int count = vertexCount * vertexCount;
        heights = new float[vertexCount][vertexCount];
        float[] vertices = new float[count * 3];
        float[] normals = new float[count * 3];
        float[] textures = new float[count * 2];
        int[] indices = new int[6 * (vertexCount - 1) * (vertexCount - 1)];
        int vertexPointer = 0;
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                vertices[vertexPointer * 3] = (float) j / ((float) vertexCount - 1) * size;
                heights[j][i] = calculateHeight(j, i, heightMap, maxHeight);
                vertices[vertexPointer * 3 + 1] = heights[j][i];
                vertices[vertexPointer * 3 + 2] = (float) i / ((float) vertexCount - 1) * size;
                Vector3f normal = calculateNormal(j, i, heightMap, maxHeight);
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
        return new RawMesh(vertices, textures, normals, indices);
    }

    private float calculateHeight(int x, int z, RawTexture heightMap, float maxHeight) {
        if (heightMap == null || x < 0 || x >= heightMap.getHeight() || z < 0 || z >= heightMap.getHeight()) {
            return 0;
        }
        float height = heightMap.getPixels()[z * heightMap.getWidth() + x];
        height += MAX_COLOUR / 2f;
        height /= MAX_COLOUR / 2f;
        height *= maxHeight;
        return height;
    }

    private Vector3f calculateNormal(int x, int z, RawTexture heightMap, float maxHeight) {
        float heightLeft = calculateHeight(x - 1, z, heightMap, maxHeight);
        float heightRight = calculateHeight(x + 1, z, heightMap, maxHeight);
        float heightDown = calculateHeight(x, z - 1, heightMap, maxHeight);
        float heightUp = calculateHeight(x, z + 1, heightMap, maxHeight);
        return new Vector3f(heightLeft - heightRight, 2f, heightDown - heightUp).normalize();


    }
}
