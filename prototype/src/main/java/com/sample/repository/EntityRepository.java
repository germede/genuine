package com.sample.repository;

import org.fluentness.model.Shape;
import org.fluentness.model.Texture;
import org.fluentness.repository.AbstractReadRepository;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.generator.TerrainGenerator;
import org.fluentness.service.loader.Loader;
import org.fluentness.view.entity.Entity;
import org.fluentness.view.entity.Terrain;

import java.util.Random;

public class EntityRepository extends AbstractReadRepository {

    private final Random random = new Random();

    private final Loader loader;
    private final TerrainGenerator terrainGenerator;

    public EntityRepository(Loader loader, TerrainGenerator terrainGenerator) {
        this.loader = loader;
        this.terrainGenerator = terrainGenerator;
    }

    public Entity[] lowPolyTrees() {
        return randomize("plants/lowPolyTree.obj", "plants/lowPolyTree.png", 100);
    }

    public Entity[] highGrasses() {
        return randomize("plants/highGrass.obj", "plants/highGrass.png", 100);
    }

    public Entity[] flowers() {
        return randomize("plants/highGrass.obj", "plants/flower.png", 30);

    }

    public Entity[] ferns() {
        return randomize("plants/fern.obj", "plants/fern.png", 100);
    }

    public Terrain[] terrains() {
        return new Terrain[]{new Terrain(
            terrainGenerator.generate(128, 2000),
            2000,
            0,
            0,
            loader.loadTexture("terrains/maps/blendMap.png"),
            loader.loadTexture("terrains/grass.png"),
            loader.loadTexture("terrains/flower.png"),
            loader.loadTexture("terrains/mud.png"),
            loader.loadTexture("terrains/path.png")
        )};
    }

    private Entity[] randomize(String modelPath, String texturePath, int count) {
        Shape shape = loader.loadShape(modelPath);
        Texture texture = loader.loadTexture(texturePath);
        Entity[] trees = new Entity[count];
        for (int i = 0; i < trees.length; i++) {
            int max = 1000;
            int min = -1000;
            trees[i] = new Entity(
                shape,
                texture,
                new Vector3f(random.nextInt(max - min) + min, 0, random.nextInt(max - min) + min),
                new Vector3f(0, random.nextFloat() * 180f, 0),
                random.nextFloat() * 10
            );
        }
        return trees;
    }
}
