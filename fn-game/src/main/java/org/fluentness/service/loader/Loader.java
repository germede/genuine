package org.fluentness.service.loader;

import org.fluentness.repository.shape.RawShape;
import org.fluentness.repository.shape.Shape;
import org.fluentness.repository.texture.Texture;
import org.fluentness.service.Service;

public interface Loader extends Service {

    Shape loadShape(String path);

    Shape loadShape(RawShape rawShape);

    Texture loadTexture(String path);

}
