package org.fluentness.repository.crud;

import java.io.Serializable;

public abstract class CrudModel implements Serializable {

    private long id = 0;

    public final long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }
}
