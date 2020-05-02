package org.fluentness.repository;

import java.io.Serializable;

public interface Model extends Serializable {

    int getId();

    void setId(int id);
}
