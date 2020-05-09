package org.fluentness.service.persistence;

public class Condition {

    private final String field;
    private final String operator;
    private final Object value;

    public Condition(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String toString() {
        return field + operator + '\'' + value + '\'';
    }
}
