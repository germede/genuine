package com.sample.model;

import org.fluentness.model.Model;

public class SongModel implements Model {

    @Override
    public String getTable() {
        return "song";
    }

    @Override
    public String getPrimaryKey() {
        return "id";
    }

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
