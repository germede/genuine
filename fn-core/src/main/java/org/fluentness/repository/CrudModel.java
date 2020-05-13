package org.fluentness.repository;

import java.io.Serializable;

public interface CrudModel extends Model, Serializable {

    String ID_NAME = "id";

    int getId();

    void setId(int id);

}
