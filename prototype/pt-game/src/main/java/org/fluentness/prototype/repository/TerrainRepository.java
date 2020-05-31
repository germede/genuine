package org.fluentness.prototype.repository;

import org.fluentness.repository.AbstractTerrainRepository;
import org.fluentness.service.loader.Loader;

public class TerrainRepository extends AbstractTerrainRepository {

    public TerrainRepository(Loader loader) {
        super(loader);
        terrains.add(
            generate(
                0, 0, 2000, 128,
                "terrains/maps/heightMap.png",
                "terrains/maps/blendMap.png",
                "terrains/grass.png",
                "terrains/flower.png",
                "terrains/mud.png",
                "terrains/path.png"
            )
        );
    }
}
