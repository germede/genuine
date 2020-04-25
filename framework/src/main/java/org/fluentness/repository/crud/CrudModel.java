package org.fluentness.repository.crud;

import org.fluentness.repository.Model;

public abstract class CrudModel implements Model {

    private long id = 0;

    @Override
    public final long getId() {
        return id;
    }

    @Override
    public final void setId(long id) {
        this.id = id;
    }
}
