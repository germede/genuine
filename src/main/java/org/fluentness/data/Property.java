package org.fluentness.data;

public abstract class Property {

    private boolean isPrimaryKey = false;
    private boolean isAutoincrement = false;
    private boolean isNullable = false;

    public Property primaryKey() {
        this.isPrimaryKey = true;
        return this;
    }

    public Property autoincrement() {
        this.isAutoincrement = true;
        return this;
    }

    public Property nullable() {
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
