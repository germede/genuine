package org.fluentness.repository;

import java.io.Serializable;

public abstract class Model implements Serializable {

    private final long id;

    public Model(long id) {
        this.id = id;
    }

    public Model() {
        this.id = 0; // 0 means model ist not persisted
    }

    public final long getId() {
        return id;
    }

    public String getTableName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

}
