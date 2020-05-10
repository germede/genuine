package com.sample.repository;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.view.entity.Entity;
import org.fluentness.view.entity.Terrain;
import org.fluentness.model.shape.ShapeModel;
import org.fluentness.service.parser.ObjParser;
import org.fluentness.service.parser.Parser;
import org.fluentness.model.texture.TerrainTexture;

import java.util.Random;

public class EntityRepository {



    private final Parser parser = new ObjParser();
    private final Random random = new Random();
    private final int count = 100;
    private final int max = 1000;
    private final int min = -1000;

    public Entity[] loadTrees() {
        ShapeModel treeModel = parser.loadShape("plants/lowPolyTree.obj", "plants/lowPolyTree.png");
        Entity[] trees = new Entity[count];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Entity(treeModel)
                .setTranslation(new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min))
                .setRotation(new Vector3f(0, random.nextFloat() * 180f, 0))
                .setScale(5);
        }
        return trees;
    }

    public Entity[] loadGrasses() {
        ShapeModel grassModel = parser.loadShape("plants/highGrass.obj", "plants/highGrass.png");
        Entity[] grasses = new Entity[count];

        for (int i = 0; i < grasses.length; i++) {
            grasses[i] = new Entity(grassModel)
                .setTranslation(new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min))
                .setScale(20);
        }
        return grasses;
    }

    public Entity[] loadFlowers() {
        ShapeModel flowerModel = parser.loadShape("plants/highGrass.obj", "plants/flower.png");
        Entity[] flowers = new Entity[count/6];

        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = new Entity(flowerModel)
                .setTranslation(new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min))
                .setScale(20);
        }
        return flowers;
    }

    public Entity[] loadFerns() {
        ShapeModel fernModel = parser.loadShape("plants/fern.obj", "plants/fern.png");
        Entity[] ferns = new Entity[count];

        for (int i = 0; i < ferns.length; i++) {
            ferns[i] = new Entity(fernModel)
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
