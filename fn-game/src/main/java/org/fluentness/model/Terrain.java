package org.fluentness.model;

import org.fluentness.service.loader.Mesh;
import org.fluentness.service.loader.Texture;
import org.fluentness.service.algebra.Vector3f;

public class Terrain implements Model {

    public final Mesh mesh;
    public final Texture[] textures;

    public Vector3f translation;
    public Vector3f rotation = new Vector3f(0, 0, 0);
    public float scale = 1;

    public float repeatTextures = 40;

    public final float size;
    public final float[][] heights;

    public float shineDamper = 1;
    public float reflectivity = 0.5f;

    public Terrain(float size, float[][] heights, Mesh mesh, Texture... textures) {
        this.size = size;
        this.heights = heights;
        this.mesh = mesh;
        this.textures = textures;
    }

    public float getHeightAt(float sceneX, float sceneZ) {
        float terrainX = sceneX - translation.x;
        float terrainZ = sceneZ - translation.z;
        float meshSquareSize = size / ((float) heights.length - 1);
        int squareX = (int) Math.floor(terrainX / meshSquareSize);
        int squareZ = (int) Math.floor(terrainZ / meshSquareSize);
        if (squareX >= heights.length - 1 || squareZ >= heights.length - 1 || squareX < 0 || squareZ < 0) {
            return 0;
        }
        float xCoordinate = (terrainX % meshSquareSize) / meshSquareSize;
        float zCoordinate = (terrainZ % meshSquareSize) / meshSquareSize;
        if (xCoordinate <= (1 - zCoordinate)) {
            return barryCentric(
                0, heights[squareX][squareZ], 0, 1,
                heights[squareX + 1][squareZ], 0, 0,
                heights[squareX][squareZ + 1], 1,
                xCoordinate, zCoordinate
            );
        } else {
            return barryCentric(
                1, heights[squareX + 1][squareZ], 0, 1,
                heights[squareX + 1][squareZ + 1], 1, 0,
                heights[squareX][squareZ + 1], 1,
                xCoordinate, zCoordinate
            );
        }
    }

    private float barryCentric(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float posX, float posY) {
        float det = (z2 - z3) * (x1 - x3) + (x3 - x2) * (z1 - z3);
        float l1 = ((z2 - z3) * (posX - x3) + (x3 - x2) * (posY - z3)) / det;
        float l2 = ((z3 - z1) * (posX - x3) + (x1 - x3) * (posY - z3)) / det;
        float l3 = 1.0f - l1 - l2;
        return l1 * y1 + l2 * y2 + l3 * y3;
    }

    @Override
    public long getId() {
        return 0;
    }
}
