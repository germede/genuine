package com.sample.model;

import org.fluentness.model.Model;

public class SongModel implements Model {

    @Override
    public Properties getProperties() {
        return properties(
                id -> id(),
                title -> string(),
                artist -> string(),
                album -> string().nullable(),
                year -> integer(),
                is_new -> bool()
        );
    }
}
