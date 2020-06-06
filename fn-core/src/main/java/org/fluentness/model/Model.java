package org.fluentness.model;

import java.io.Serializable;

public interface Model extends Serializable {

    default long getId() throws NoSuchFieldException, IllegalAccessException {
        return (long) this.getClass().getField("id").get(this);
    }

}
