package org.fluentness.service.loader;

import org.fluentness.repository.shape.RawShape;
import org.fluentness.repository.shape.Shape;
import org.fluentness.repository.texture.Texture;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

public interface Loader extends Service {

    Setting<Float> MIPMAP_BIAS = new Setting<>(0.4f);

    Shape loadShape(String path);

    Shape loadShape(RawShape rawShape);

    Texture loadTexture(String path);

}
