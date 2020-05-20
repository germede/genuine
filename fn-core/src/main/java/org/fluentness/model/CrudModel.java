package org.fluentness.model;

import java.io.Serializable;

public interface CrudModel extends Model, Serializable {

    String ID_NAME = "id";

    int getId();

    void setId(int id);

}
