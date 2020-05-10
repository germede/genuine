package org.fluentness.service.loader;

import org.fluentness.service.Service;

public interface Loader extends Service {

    int loadShape(float[] vertices, float[] textures, float[] normals, int[] indices);

}
