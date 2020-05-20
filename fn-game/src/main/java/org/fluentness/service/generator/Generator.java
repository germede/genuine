package org.fluentness.service.generator;

import org.fluentness.view.scene.terrain.Terrain;
import org.fluentness.service.Service;

public interface Generator extends Service {

    Terrain generate(int gridX, int gridZ, float size, float maxHeight, String heightMapPath, String... texturePaths);
}
