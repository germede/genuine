package org.fluentness.repository;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.loader.Loader;
import org.fluentness.controller.scene.Entity;

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
