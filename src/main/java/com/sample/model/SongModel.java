package com.sample.model;

import org.fluentness.model.Model;

public class SongModel implements Model {

    @Override
    public Columns getColumns() {
        return columns(
                id -> id(),
                title -> string(),
                artist -> string(),
                album -> string().nullable(),
                year -> integer(),
                is_new -> bool()
        );
    }
}
