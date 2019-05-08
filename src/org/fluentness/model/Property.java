package org.fluentness.model;

public abstract class Property {

    private boolean isPrimaryKey = false;
    private boolean nullable = false;
    private boolean readable = true;
    private boolean writable = true;

    public Property primaryKey() {
        this.isPrimaryKey = true;
        return this;
    }

    public Property nullable() {
        this.nullable = true;
        return this;
    }

    public Property readable() {
        this.readable = true;
        return this;
    }

    public Property writable() {
        this.writable = true;
        return this;
    }

    public boolean isNullable() {
        return nullable;
    }

    public boolean isReadable() {
        return readable;
    }

    public boolean isWritable() {
        return writable;
    }

    public abstract Class getType();
}
