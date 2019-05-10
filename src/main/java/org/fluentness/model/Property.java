package org.fluentness.model;

public abstract class Property {

    private boolean isPrimaryKey = false;
    private boolean nullable = false;

    public Property primaryKey() {
        this.isPrimaryKey = true;
        return this;
    }

    public Property nullable() {
        this.nullable = true;
        return this;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public boolean isNullable() {
        return nullable;
    }

    public abstract Class getType();

}
