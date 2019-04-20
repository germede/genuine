package org.fwf.mvc;

public abstract class Model<T extends Model<T>> {

    private Object savedPrimaryKey;

    public Object getSavedPrimaryKey() {
        return savedPrimaryKey;
    }

    public void setSavedPrimaryKey(Object savedPrimaryKey) {
        this.savedPrimaryKey = savedPrimaryKey;
    }
}
