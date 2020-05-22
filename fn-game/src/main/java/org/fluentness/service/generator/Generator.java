package org.fluentness.service.generator;

import org.fluentness.view.scene.terrain.Terrain;
public interface Generator {

    Terrain generate(int gridX, int gridZ, float size, float maxHeight, String heightMapPath, String... texturePaths);
}
