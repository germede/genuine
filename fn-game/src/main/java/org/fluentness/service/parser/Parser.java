package org.fluentness.service.parser;

import org.fluentness.model.shape.ShapeModel;
import org.fluentness.service.Service;

public interface Parser extends Service {

    ShapeModel load(String model, String texture);

}
