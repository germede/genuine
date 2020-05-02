package org.fluentness.service.persistence;

public class Condition {

    public static final Condition eq(String field, Object value) {
        return new Condition(field, "=", value);
    }

    private final String field;
    private final String operator;
    private final Object value;

    private Condition(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String toString() {
        return field + operator + '\'' + value + '\'';
    }
}
