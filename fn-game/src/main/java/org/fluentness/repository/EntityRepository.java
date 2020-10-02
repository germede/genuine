package org.fluentness.repository;

import org.fluentness.model.Entity;
import org.fluentness.model.Terrain;
import org.fluentness.service.loader.Mesh;
import org.fluentness.service.loader.Texture;
import org.fluentness.service.loader.Loader;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class EntityRepository implements Repository<Entity> {

    protected final List<Entity> entities = new LinkedList<>();
    protected final Random random = new Random();
    protected final Loader loader;

    public EntityRepository(Loader loader) {
        this.loader = loader;
    }

    protected Entity[] randomize(String modelPath, String texturePath, int count, int min, int max) {
        Mesh mesh = loader.loadShape(modelPath);
        Texture texture = loader.loadTexture(texturePath);
        Entity[] entities = new Entity[count];
        for (int i = 0; i < entities.length; i++) {
            entities[i] = new Entity(mesh, texture);
            int x = random.nextInt(max - min) + min;
            int z = random.nextInt(max - min) + min;
            entities[i].translation.x = x;
            entities[i].translation.z = z;
            entities[i].translation.y = 0;
            entities[i].rotation.y = random.nextFloat() * 180f;
            entities[i].scale = random.nextFloat() * 10;
        }
        return entities;
    }

    protected Entity[] randomize(String modelPath, String texturePath, int count, Terrain terrain) {
        Mesh mesh = loader.loadShape(modelPath);
        Texture texture = loader.loadTexture(texturePath);
        Entity[] entities = new Entity[count];
        int max = (int) terrain.size;
        int min = (int) -terrain.size;
        for (int i = 0; i < entities.length; i++) {
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

    @Override
    public List<Entity> selectAll() {
        return entities;
    }

}
