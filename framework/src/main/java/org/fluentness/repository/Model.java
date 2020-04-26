package org.fluentness.repository;

import java.io.Serializable;

public interface Model extends Serializable {

    long INITIAL_ID = 0;

    long getId();

    void setId(long id);
}
