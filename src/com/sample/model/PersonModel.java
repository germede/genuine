package com.sample.model;

import org.fluentness.model.IntegerProperty;
import org.fluentness.model.Model;
import org.fluentness.model.StringProperty;

public class PersonModel implements Model {

    @Override
    public Properties getProperties() {
        return new Properties(
                id -> new IntegerProperty().primaryKey().readable().writable(),
                name -> new StringProperty().readable(),
                surname -> new StringProperty().readable().writable()
        );
    }
}
