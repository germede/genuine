package org.fluentness.service.parser;

import org.fluentness.model.Shape;
import org.fluentness.service.Service;

public interface Parser extends Service {

    Shape loadShape(String model, String texture);

    Texture loadShape(String model, String texture);

}
