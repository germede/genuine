package org.fluentness.prototype.repository;

import org.fluentness.model.Terrain;
import org.fluentness.service.loader.Loader;

import java.util.Collections;

public class EntityRepository extends org.fluentness.repository.EntityRepository {

    public EntityRepository(Loader loader, TerrainRepository terrainRepository) {
        super(loader);

        Terrain terrain = terrainRepository.selectAll().get(0);

        Collections.addAll(entities, randomize("plants/lowPolyTree.obj", "plants/lowPolyTree.png", 100, terrain));
        Collections.addAll(entities, randomize("plants/highGrass.obj", "plants/highGrass.png", 100, terrain));
        Collections.addAll(entities, randomize("plants/highGrass.obj", "plants/flower.png", 30, terrain));
        Collections.addAll(entities, randomize("plants/fern.obj", "plants/fern.png", 100, terrain));
    }
}
