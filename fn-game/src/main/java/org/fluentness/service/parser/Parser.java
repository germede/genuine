package org.fluentness.service.parser;

import org.fluentness.engine.model.ObjectModel;
import org.fluentness.service.Service;

public interface Parser extends Service {

    ObjectModel load(String model, String texture);

}
