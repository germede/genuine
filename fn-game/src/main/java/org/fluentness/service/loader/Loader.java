package org.fluentness.service.loader;

import org.fluentness.repository.RawShape;
import org.fluentness.repository.Shape;
import org.fluentness.repository.Texture;
import org.fluentness.service.Service;

public interface Loader extends Service {

    Shape loadShape(String path);

    Shape loadShape(RawShape rawShape);

    Texture loadTexture(String path);

}
