package com.sample.model;

import org.fluentness.model.Model;

public class PersonModel implements Model {

    @Override
    public Properties getProperties() {
        return properties(
                id -> integer().primaryKey(),
                name -> string(),
                surname -> string().nullable()
        );
    }
}
