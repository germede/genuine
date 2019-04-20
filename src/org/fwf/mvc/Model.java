package org.fwf.mvc;

public abstract class Model<T extends Model<T>> implements Cloneable {

    private Model<T> original;

    public Model<T> getOriginal() {
        return original;
    }

    public void saveOriginal() throws CloneNotSupportedException {
        this.original = (T)super.clone();
    }
}
