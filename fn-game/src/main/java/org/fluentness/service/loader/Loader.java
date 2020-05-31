package org.fluentness.service.loader;

import org.fluentness.service.parser.RawMesh;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

public interface Loader extends Service {

    Setting<Float> MIPMAP_BIAS = new Setting<>(0.4f);

    Mesh loadShape(String path);

    Mesh loadShape(RawMesh rawMesh);

    Texture loadTexture(String path);

}
