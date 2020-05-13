package com.sample.repository;

import org.fluentness.repository.Repository;
import org.fluentness.repository.shape.Shape;
import org.fluentness.repository.texture.Texture;
import org.fluentness.controller.scene.entity.Entity;
import org.fluentness.controller.scene.entity.Player;
import org.fluentness.controller.scene.terrain.Terrain;
import org.fluentness.service.generator.TerrainGenerator;
import org.fluentness.service.loader.Loader;

import java.util.Random;

public class GameRepository implements Repository {

    private final Loader loader;
    private final TerrainGenerator terrainGenerator;

    private final Random random = new Random();

    public GameRepository(Loader loader, TerrainGenerator terrainGenerator) {
        this.loader = loader;
        this.terrainGenerator = terrainGenerator;
    }

    public Player player() {
        Player player = new Player(loader.loadShape("bunny.obj"), loader.loadTexture("white.png"));
        player.rotation.y = 180;
        return player;
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

    public Terrain terrain() {
        return new Terrain(
            terrainGenerator.generate(128, 2000),
            2000,
            0,
            0,
            loader.loadTexture("terrains/maps/blendMap.png"),
            loader.loadTexture("terrains/grass.png"),
            loader.loadTexture("terrains/flower.png"),
            loader.loadTexture("terrains/mud.png"),
            loader.loadTexture("terrains/path.png")
        );
    }


    protected Entity[] randomize(String modelPath, String texturePath, int count) {
        Shape shape = loader.loadShape(modelPath);
        Texture texture = loader.loadTexture(texturePath);
        Entity[] entities = new Entity[count];
        for (int i = 0; i < entities.length; i++) {
            int max = 1000;
            int min = -1000;
            entities[i] = new Entity(shape, texture);
            entities[i].translation.x = random.nextInt(max - min) + min;
            entities[i].translation.z = random.nextInt(max - min) + min;
            entities[i].rotation.y = random.nextFloat() * 180f;
            entities[i].scale = random.nextFloat() * 10;
        }
        return entities;
    }

}
