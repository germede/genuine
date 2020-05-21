package org.fluentness.prototype.repository;

import org.fluentness.view.scene.entity.Entity;
import org.fluentness.view.scene.entity.Player;
import org.fluentness.view.scene.terrain.Terrain;
import org.fluentness.repository.Repository;
import org.fluentness.model.mesh.Mesh;
import org.fluentness.model.texture.Texture;
import org.fluentness.service.generator.Generator;
import org.fluentness.service.loader.Loader;

import java.util.Random;

public class GameRepository implements Repository {

    private final Loader loader;
    private final Generator generator;

    private final Random random = new Random();
    private Terrain terrain;

    public GameRepository(Loader loader, Generator generator) {
        this.loader = loader;
        this.generator = generator;

        terrain = generator.generate(
            0, 0, 2000, 128,
            "terrains/maps/heightMap.png",
            "terrains/maps/blendMap.png",
            "terrains/grass.png",
            "terrains/flower.png",
            "terrains/mud.png",
            "terrains/path.png"
        );
    }

    public Player player() {
        Player player = new Player(loader.loadShape("dragon.obj"), loader.loadTexture("white.png"));
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
        return terrain;
    }

    protected Entity[] randomize(String modelPath, String texturePath, int count) {
        Mesh mesh = loader.loadShape(modelPath);
        Texture texture = loader.loadTexture(texturePath);
        Entity[] entities = new Entity[count];
        for (int i = 0; i < entities.length; i++) {
            int max = 1000;
            int min = -1000;
            entities[i] = new Entity(mesh, texture);
            int x = random.nextInt(max - min) + min;
            int z = random.nextInt(max - min) + min;
            entities[i].translation.x = x;
            entities[i].translation.z = z;
            entities[i].translation.y = terrain.getHeightAt(x, z);
            entities[i].rotation.y = random.nextFloat() * 180f;
            entities[i].scale = random.nextFloat() * 10;
        }
        return entities;
    }

}
