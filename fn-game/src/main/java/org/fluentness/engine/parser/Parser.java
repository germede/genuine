package org.fluentness.engine.parser;

import org.fluentness.engine.model.ObjectModel;

public interface Parser {

    ObjectModel load(String model, String texture);

}
