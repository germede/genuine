package org.fluentness.service.loader;

import org.fluentness.model.mesh.RawMesh;
import org.fluentness.model.mesh.Mesh;
import org.fluentness.model.texture.Texture;
import org.fluentness.service.configuration.Setting;

public interface Loader {

    Setting<Float> MIPMAP_BIAS = new Setting<>(0.4f);

    Mesh loadShape(String path);

    Mesh loadShape(RawMesh rawMesh);

    Texture loadTexture(String path);

}
