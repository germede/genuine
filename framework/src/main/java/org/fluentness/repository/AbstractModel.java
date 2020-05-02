package org.fluentness.repository;

public abstract class AbstractModel implements Model {

    private int id;

    public AbstractModel() {
        this.id = 0;
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
