package org.fwf.mvc;

public abstract class Model<T extends Model<T>> implements Cloneable {

    private Model<T> original;

    public Model<T> getOriginal() {
        return original;
    }

    public void setOriginal(Model<T> original) {
        this.original = original;
    }

    public T clone() throws CloneNotSupportedException {
        return (T) super.clone();
    }
}
