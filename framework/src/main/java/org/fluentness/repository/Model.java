package org.fluentness.repository;

import java.io.Serializable;

public abstract class Model implements Serializable {

    private long id = 0;

    public final long getId() {
        return id;
    }

}
