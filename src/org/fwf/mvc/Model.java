package org.fwf.mvc;

import org.fwf.ann.Column;

public abstract class Model<T extends Model<T>> {

    @Column
    private int id;

    public int getId() {
        return id;
    }

    public T setId(int id) {
        this.id = id;
        return (T) this;
    }
}
