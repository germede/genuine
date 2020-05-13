package org.fluentness.repository;

public abstract class AbstractCrudModel implements CrudModel {

    protected int id;

    public AbstractCrudModel(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
