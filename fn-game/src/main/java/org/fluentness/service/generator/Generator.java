package org.fluentness.service.generator;

import org.fluentness.repository.shape.Shape;
import org.fluentness.service.MultiService;
import org.fluentness.service.Service;

@MultiService
public interface Generator extends Service {

    Shape generate(float size, float maxHeight, String heightMapPath);

    Shape generate(float size, int vertexCount);
}
