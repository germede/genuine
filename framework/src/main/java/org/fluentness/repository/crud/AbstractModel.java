package org.fluentness.repository.crud;

import org.fluentness.repository.Model;

public abstract class AbstractModel implements Model {

    private long id;

    public AbstractModel() {
        this.id = 0;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
