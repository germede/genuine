package com.sample.repository;

import org.fluentness.repository.AbstractGameRepository;
import org.fluentness.service.generator.TerrainGenerator;
import org.fluentness.service.loader.Loader;
import org.fluentness.view.scene.entity.Entity;
import org.fluentness.view.scene.entity.Terrain;

public class GameRepository extends AbstractGameRepository {

    private final TerrainGenerator terrainGenerator;

    public GameRepository(Loader loader, TerrainGenerator terrainGenerator) {
        super(loader);
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

}
