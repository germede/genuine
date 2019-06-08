package org.fluentness.model;

public abstract class Attribute {

    private boolean isPrimaryKey = false;
    private boolean isAutoincrement = false;
    private boolean isNullable = false;

    public Attribute primaryKey() {
        this.isPrimaryKey = true;
        return this;
    }

    public Attribute autoincrement() {
        this.isAutoincrement = true;
        return this;
    }

    public Attribute nullable() {
        this.isNullable = true;
        return this;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public boolean isAutoincrement() {
        return isAutoincrement;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public abstract Class getType();
}
