package org.fluentness.repository;

import org.fluentness.controller.scene.entity.Entity;
import org.fluentness.service.loader.Loader;

import java.util.Random;

public abstract class AbstractGameRepository implements Repository {

    protected final Random random = new Random();
    protected final Loader loader;

    public AbstractGameRepository(Loader loader) {
        this.loader = loader;
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
