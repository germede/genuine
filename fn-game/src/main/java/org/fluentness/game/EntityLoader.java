package org.fluentness.game;

import org.fluentness.engine.algebra.Vector3f;
import org.fluentness.engine.entity.Object;
import org.fluentness.engine.entity.Terrain;
import org.fluentness.engine.model.ObjectModel;
import org.fluentness.engine.parser.ObjParser;
import org.fluentness.engine.parser.Parser;
import org.fluentness.engine.texture.TerrainTexture;

import java.util.Random;

public class EntityLoader {

    private final Parser parser = new ObjParser();
    private final Random random = new Random();
    private final int count = 100;
    private final int max = 1000;
    private final int min = -1000;

    public Object[] loadTrees() {
        ObjectModel treeModel = parser.load("plants/lowPolyTree.obj", "plants/lowPolyTree.png");
        Object[] trees = new Object[count];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Object(treeModel)
                .setTranslation(new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min))
                .setRotation(new Vector3f(0, random.nextFloat() * 180f, 0))
                .setScale(5);
        }
        return trees;
    }

    public Object[] loadGrasses() {
        ObjectModel grassModel = parser.load("plants/highGrass.obj", "plants/highGrass.png");
        Object[] grasses = new Object[count];

        for (int i = 0; i < grasses.length; i++) {
            grasses[i] = new Object(grassModel)
                .setTranslation(new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min))
                .setScale(20);
        }
        return grasses;
    }

    public Object[] loadFlowers() {
        ObjectModel flowerModel = parser.load("plants/highGrass.obj", "plants/flower.png");
        Object[] flowers = new Object[count/6];

        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = new Object(flowerModel)
                .setTranslation(new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min))
                .setScale(20);
        }
        return flowers;
    }

    public Object[] loadFerns() {
        ObjectModel fernModel = parser.load("plants/fern.obj", "plants/fern.png");
        Object[] ferns = new Object[count];

        for (int i = 0; i < ferns.length; i++) {
            ferns[i] = new Object(fernModel)
                .setTranslation(new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min))
                .setScale(5);
        }
        return ferns;
    }

    public Terrain loadTerrain() {
        return new Terrain(
            0,
            0,
            new TerrainTexture("terrains/maps/blendMap.png"),
            new TerrainTexture("terrains/grass.png"),
            new TerrainTexture("terrains/flower.png"),
            new TerrainTexture("terrains/mud.png"),
            new TerrainTexture("terrains/path.png")
        );
    }
}
